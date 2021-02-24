package study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 14495 피보나치 비스무리한 수열
// 1차 : 틀림 - new int[N+1] 때문인듯. N이 0,1,2인 경우 outofIndex
// 2차 : 틀림 - 22%쯤에서 틀림. 머지..
// 3차 : 성공 - int 배열이 아니라 long배열로 바꿈.
public class SimilarFibonacci {
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] fibo = new long[117];
		
		fibo[1]=fibo[2]=fibo[3]=1;
		
		for(int i=4;i<=N;i++) 
			fibo[i] = fibo[i-1]+fibo[i-3];
		
		System.out.println(fibo[N]);
	}
}
