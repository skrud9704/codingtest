package study9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 베르트랑공준
// 1차시도 : 정답 26900KB/268ms
// 2차시도 : 정답. 범위가 있으므로 에라토스테네스의 체를 미리 연산시켜놓음(반복연산없앰) 15064KB/168ms 
public class BetrandPastulate {
	
	private static int LIMIT = 123456*2;
	private static boolean[] sieve = new boolean[LIMIT+1];
	
	
	private static void sieveOfEratosthenes() {
		for(int i=2;i<=Math.sqrt(LIMIT);i++) {
			int j=2;
			while(i*j <= LIMIT) {
				if(!sieve[i*j])
					sieve[i*j]=true;
				j++;
			}
		}
	}
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		sieveOfEratosthenes();
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			
			int answer = 0;
			for(int i=N+1;i<=2*N;i++)
				if(!sieve[i]&&i!=1)
					answer++;
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb);
		
		
	}

}