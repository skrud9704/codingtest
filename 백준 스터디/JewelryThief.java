package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

// ���� 1202�� ��������
// 1���� - ���� (class�� Main)
// 2���� - ���� (�ð� �ʰ�) : ����for�� - �ð����⵵ O(MN) 30��*30�� (�ð����� 1s)
// 3���� - ���� (class�� Main)
// 4���� - ���� (��Ÿ�� ����) 
// 5���� - ���� : priority queue ��� - �ð����⵵ O(M+N)
public class JewelryThief {
	
	public static long solution2(InputData inputData) {
		long answer = 0;
		// ������ ���԰� ���� �ͺ���, ������ ���԰� ���� �ͺ��� ����
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
		int M, V;	// ���� , ����
		
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
