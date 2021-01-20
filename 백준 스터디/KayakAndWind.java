package greedy;

import java.io.*;
import java.util.*;

// 백준 2891번 카약과 강풍
// 1차시 - 성공
public class KayakAndWind {
	
	public static void solution(Team[] teams) {
		
		int dontGo = 0;
		
		for(int i=0;i<teams.length;i++) {
			if(!teams[i].isCrash || teams[i].haveSpare)
				continue;
			// 카약이 손상되고, 스페어도 없는 팀 -> 앞 뒤 팀을 본다
			// 앞 팀 
			if(i!=0 && teams[i-1].haveSpare && !teams[i-1].isCrash && !teams[i-1].lentOther) {
				teams[i-1].lentOther=true;
				continue;
			}
			// 뒤 팀 
			if(i!=teams.length-1 && teams[i+1].haveSpare && !teams[i+1].isCrash && !teams[i+1].lentOther) {			
				teams[i+1].lentOther=true;
				continue;
			}
			
			dontGo++;
		}
		
		System.out.println(dontGo);
	}

	public static class Team{
		boolean isCrash =false;
		boolean haveSpare =false;
		boolean lentOther =false;
		
		public Team() {}
	}
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int S = Integer.parseInt(s1[1]);
		int R = Integer.parseInt(s1[2]);
		Team[] teams= new Team[N];
		for(int i=0;i<N;i++) {
			teams[i] = new Team();
		}
		
		String[] s2 = br.readLine().split(" ");
		for(int i=0;i<S;i++) {
			teams[Integer.parseInt(s2[i])-1].isCrash = true;
		}
		
		String[] s3 = br.readLine().split(" ");
		for(int i=0;i<R;i++) {
			teams[Integer.parseInt(s3[i])-1].haveSpare = true;
		}
		
		solution(teams);
	}
}
