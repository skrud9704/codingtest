package study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 9655 돌게임
public class StoneGame {
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int turn = 0;
		while(N > 0) {
			if(N >= 3)
				N-=3;
			else
				N-=1;
			turn++;
		}
		
		if(turn%2==1)
			System.out.println("SK");
		else
			System.out.println("CY");
		
	}

}
