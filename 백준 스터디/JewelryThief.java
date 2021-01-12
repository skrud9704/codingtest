package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

// 백준 1202번 보석도둑
// 1차시 - 실패 (class명 Main)
// 2차시 - 실패 (시간 초과) : 이중for문 - 시간복잡도 O(MN) 30만*30만 (시간제한 1s)
// 3차시 - 실패 (class명 Main)
// 4차시 - 실패 (런타임 에러) 
// 5차시 - 성공 : priority queue 사용 - 시간복잡도 O(M+N)
public class JewelryThief {
	
	public static long solution2(InputData inputData) {
		long answer = 0;
		// 가방은 무게가 적은 것부터, 보석을 무게가 적은 것부터 본다
		Arrays.sort(inputData.C);
		Arrays.sort(inputData.j);
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		int j=0;
		for(int i=0;i<inputData.K;i++) {
			while(j<inputData.N && inputData.j[j].M <= inputData.C[i]) {
				q.add(inputData.j[j].V);
				j++;
			}
			if(!q.isEmpty()) {
				answer+=q.poll();
			}
		}
		
		return answer;
	}
	
	private static class InputData{
		int N, K;
		Jewerly[] j;
		int[] C;
	}
	
	private static class Jewerly implements Comparable<Jewerly>{
		int M, V;	// 무게 , 가격
		
		public Jewerly(int M, int V){
			this.M = M;
			this.V = V;
		}

		@Override
		public int compareTo(Jewerly o) {	
			return this.M - o.M;
		}
	}
	
	private static InputData processStdin() throws IOException {
		InputData id = new InputData();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s1 = br.readLine().split(" ");
		id.N = Integer.parseInt(s1[0]);
		id.K = Integer.parseInt(s1[1]);
		id.j = new Jewerly[id.N];
		id.C = new int[id.K];
		
		for(int i=0;i<id.N;i++) {
			String[] s2 = br.readLine().split(" ");
			id.j[i] = new Jewerly(Integer.parseInt(s2[0]),Integer.parseInt(s2[1]));
		}
		
		for(int i=0;i<id.K;i++) {
			id.C[i] = Integer.parseInt(br.readLine());
		}
		
		return id;
	}
	
	public static void main(final String[] args) throws IOException {
		InputData id = processStdin();
		System.out.println(solution2(id));
	}

}
