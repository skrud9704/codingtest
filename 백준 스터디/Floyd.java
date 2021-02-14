package study6;

import java.io.*;
import java.util.*;

// 백준 11404 플로이드
// 시작도시와 도착도시를 연결하는 노선이 하나가 아닐 수 있음을 명심
// 그 경우 여러 노선중 가장 비용이 적은 노선으로 저장해야함. 
public class Floyd {
	
	private static int MAX = 100000000;
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] floyd = new int[N+1][N+1];
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<N+1;j++) {
				if(i==j) floyd[i][j] = 0;
				else floyd[i][j] = MAX;
			}
		}
		
		for(int i=0;i<M;i++) {
			String[] s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int weight = Integer.parseInt(s[2]);
			
			if(floyd[start][end]!=MAX && floyd[start][end]!=0)
				floyd[start][end] = Math.min(weight, floyd[start][end]);
			else
				floyd[start][end]=weight;
		}
		
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);					
				}
			}
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(floyd[i][j]==MAX)
					System.out.print(0+" ");
				else
					System.out.print(floyd[i][j]+" ");
			}
			System.out.println();			
		}
		
		
	}
}
