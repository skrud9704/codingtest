package study6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1507 궁금한 민호
// 1차 시도 : 틀림 9% .. 왜?
// 2차 시도 : -1인 경우 생각하지 않음. 구하는 도중 최소값이므로 그보다 큰 경우가 생기면 안되는 점을 고려해 코드 수정.
public class CuriousMinho {
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 도시 수 1~20개
		int[][] floyd = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				floyd[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int deleteHour = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(i!=j && i!=k && k!=j) {
						if(floyd[i][j] == floyd[i][k]+floyd[k][j]) {
							deleteHour += floyd[i][j];
							break;
						}else if(floyd[i][j] > floyd[i][k]+floyd[k][j]) {
							System.out.println(-1);
							return;
						}
					}	
				}
			}
		}
		
		int answer = 0;
		for(int i=0;i<N;i++) 
			for(int j=0;j<N;j++) 
				answer += floyd[i][j];
		
		System.out.println((answer - deleteHour)/2);

	}

}
