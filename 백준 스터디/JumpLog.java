package study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 11497 통나무 건너뛰기
public class JumpLog {

	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] answers = new int[T];
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] logs = new int[N];
			
			String[] s = br.readLine().split(" ");
			
			for(int j=0; j<N; j++) {
				logs[j] = Integer.parseInt(s[j]);
			}
			
			Arrays.sort(logs);
			int max = 0;
			for(int k=2;k<N;k++) {
				max = Math.max(max, Math.abs(logs[i]-logs[i-2]));
			}
			
			
			answers[i] = max;
		}
		for(int i : answers)
			System.out.println(i);
	}
}
