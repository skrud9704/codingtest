package dfsbfs;

import java.io.*;
import java.util.*;


// 백준 14867 물통
// 1차 시도 : 메모리 초과 512MB
// 2차 시도 : Bucket 객체 없애고 전역변수 int 로 전환. -> 메모리 초과... 그문제 아님
// 3차 시도 : boolean[][] visited 를 Queue<String> visited로 변환 -> 시간초과
// 4차 시도 : Queue<String> visited를 HashSet<String>으로 변환 
public class WaterBucket {
	
	static private int answer = -1;
	static private int aVolume;
	static private int aGoal;
	static private int bVolume;
	static private int bGoal;
	
	
	private static class Pair{
		int aNow,bNow,depth;
		Pair(int a, int b, int depth){
			this.aNow = a;		
			this.bNow = b;
			this.depth = depth;
		}
	}
	private static void F(int mode, Pair p) {
		if(mode==0) p.aNow = aVolume;
		if(mode==1) p.bNow = bVolume;
	}
	
	private static void E(int mode, Pair p) {
		if(mode==0) p.aNow = 0;
		if(mode==1) p.bNow = 0;
	}
	
	private static void M(int mode, Pair p) {
		int eVolume=0,fNow=0,eNow=0;
		if(mode==0) {
			eVolume = bVolume; fNow = p.aNow; eNow = p.bNow;
		}
		if(mode==1) {
			eVolume = aVolume; fNow = p.bNow; eNow = p.aNow;
		}
		
		int tmpNow = eNow;
		eNow += fNow;
		if(eNow > eVolume)	// 넘쳤다면
			eNow = eVolume;
		fNow -= eVolume-tmpNow;
		if(fNow < 0)
			fNow = 0;
		
		if(mode==0) {
			p.aNow = fNow;
			p.bNow = eNow;
		}
		if(mode==1) {
			p.aNow = eNow;
			p.bNow = fNow;
		}
	}
	
	private static void solution (Queue<Pair> q, Set<String> visited) {	
		
		while(q.size()!=0) {
			Pair nowBucket = q.poll();
			System.out.println("("+nowBucket.aNow+", "+nowBucket.bNow+") poll!");
			if(nowBucket.aNow==aGoal && nowBucket.bNow==bGoal) {
				answer = nowBucket.depth;
				break;
			}
			
			for(int i=0;i<6;i++) {			
				Pair changeBucket = new Pair(nowBucket.aNow,nowBucket.bNow,nowBucket.depth+1);
			
				if(i==0) F(0,changeBucket);
				else if(i==1) F(1,changeBucket);
				else if(i==2) E(0,changeBucket);
				else if(i==3) E(1,changeBucket);
				else if(i==4) M(0,changeBucket);
				else if(i==5) M(1,changeBucket);
				
				if(changeBucket.aNow != nowBucket.aNow || changeBucket.bNow != nowBucket.bNow) {
					if(!visited.contains(changeBucket.aNow+"_"+changeBucket.bNow)) {
						System.out.println("큐에 ("+changeBucket.aNow+", "+changeBucket.bNow+") 추가");
						q.add(changeBucket);
						visited.add(changeBucket.aNow+"_"+changeBucket.bNow);
					}
				}
			}
		}
	}
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		aVolume = Integer.parseInt(s[0]);
		bVolume = Integer.parseInt(s[1]);
		aGoal = Integer.parseInt(s[2]);
		bGoal = Integer.parseInt(s[3]);

		//boolean[][] visited = new boolean[Integer.parseInt(s[0])+1][Integer.parseInt(s[1])+1]; // 메모리 초과 초래
		
		Queue<Pair> q = new LinkedList<Pair>();
		Set<String> visited = new HashSet<String>();
		
		visited.add("0_0");
		q.add(new Pair(0,0,0));
		
		solution(q,visited);
		
		System.out.println(answer);
	}
}
