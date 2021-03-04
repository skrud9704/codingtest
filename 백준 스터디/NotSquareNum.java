package study9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1016 제곱 ㄴㄴ 수 
public class NotSquareNum {
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken()); // 1~1조 -> 제곱근은 백만 정도!  
		long max = Long.parseLong(st.nextToken()); // 백만1~1조백만 
		boolean[] sieve = new boolean[(int) (max-min+1)];
		int answer = (int) (max - min + 1);
		long i = 2;
		
		while(i*i <= max) {
			long sNum = min / (i*i);
			if(min%(i*i) !=0)
				sNum++;
			
			while(sNum*(i*i) <= max) {
				if(sieve[(int) (sNum*(i*i) - min)] == false) {
					sieve[(int) (sNum*(i*i) - min)] = true;
					answer--;
				}
				sNum++;
			}
			
			i++;
		}
		
		System.out.println(answer);

	}

}
