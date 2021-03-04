package study9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlanetExplolation {
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		char[][] planet = new char[M+1][N+1];
		int[][] countJ = new int[M+1][N+1];
		int[][] countO = new int[M+1][N+1];
		int[][] countI = new int[M+1][N+1];
		
		
		for(int i=1;i<M+1;i++) {
			String[] s = br.readLine().split("");
			for(int j=1;j<N+1;j++) {
				planet[i][j] = s[j-1].charAt(0);
				
				countJ[i][j] = countJ[i - 1][j] + countJ[i][j - 1] - countJ[i - 1][j - 1];
				countO[i][j] = countO[i - 1][j] + countO[i][j - 1] - countO[i - 1][j - 1];
				countI[i][j] = countI[i - 1][j] + countI[i][j - 1] - countI[i - 1][j - 1];
				
				if(planet[i][j]=='J') 
					countJ[i][j]++;
				else if(planet[i][j]=='O') 
					countO[i][j]++;
				else 
					countI[i][j]++;
			}
		}
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int ansJ =  countJ[c][d] - countJ[c][b - 1] - countJ[a - 1][d] + countJ[a - 1][b - 1];
			int ansO =  countO[c][d] - countO[c][b - 1] - countO[a - 1][d] + countO[a - 1][b - 1];
			int ansI =  countI[c][d] - countI[c][b - 1] - countI[a - 1][d] + countI[a - 1][b - 1];
			
			sb.append(ansJ+" ").append(ansO+" ").append(ansI).append("\n");
			
		}
		
		System.out.print(sb);
		
	}

}
