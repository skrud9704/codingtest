package study9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 17390 이건 꼭 풀어야 해!
public class MustSolve {
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 1~30만 
		int Q = Integer.parseInt(st.nextToken()); // 1~30만 
		int[] arrA = new int[N+1];				// 원소 1~1000 
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++)
			arrA[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arrA);
		
		for(int i=2;i<N+1;i++)
			arrA[i] = arrA[i-1]+arrA[i];	// prefix sum 이용
		
		
		StringBuilder sb = new StringBuilder();
		while(Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			sb.append(arrA[right]-arrA[left-1]).append("\n");
			
		}
		
		System.out.print(sb);
		
	}

}
