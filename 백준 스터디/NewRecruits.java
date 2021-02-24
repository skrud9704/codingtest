package study3;

import java.util.*;
import java.io.*;

// 백준 1946번 신입 사원
// 1차시도 : 시간초과 -2중포문
// 2차시도 : 통과 
public class NewRecruits {
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> hm;
		int[] answers = new int[T];
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			hm = new HashMap<>();
			
			for(int j=0;j<N;j++) {
				String[] s = br.readLine().split(" ");
				hm.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				
			}
			int answer = N;
			
			int highRank = hm.get(1);
			for(int k=2; k<=N; k++) {
				if(highRank < hm.get(k))
					answer--;
				else if(highRank > hm.get(k))
					highRank = hm.get(k);
			}
			
			answers[i] = answer;
		}
		
		for(int i : answers)
			System.out.println(i);
	}
}