package study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 7453 합이 0인 네 정수 
public class FourNumAdd0 {
	
	private static long[] AB, CD;
	private static long cnt;
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] A = new long[N];
		long[] B = new long[N];
		long[] C = new long[N];
		long[] D = new long[N];
		AB = new long[N*N];
		CD = new long[N*N];
		
		
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			A[i] = Long.parseLong(s[0]);
			B[i] = Long.parseLong(s[1]);
			C[i] = Long.parseLong(s[2]);
			D[i] = Long.parseLong(s[3]);
		}
		
		int idx = 0;
		for(int i = 0 ; i < N ; ++i) {
			for(int j = 0 ; j < N ; ++j) {
				AB[idx] = A[i] + B[j];
				CD[idx] = C[i] + D[j];
				idx++;
			}
		}
			
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		cnt = 0;
		for(int i = 0 ; i < AB.length ; ++i) {
			cnt += upper_bound(0, CD.length, -AB[i]) - lower_bound(0, CD.length, -AB[i]);
		}

		System.out.println(cnt);
	}
		
	private static int upper_bound(int left, int right, long target) {
		while(left < right) {
			int mid = (left + right) / 2;
			if(CD[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
		
	private static int lower_bound(int left, int right, long target) {
		while(left < right) {
			int mid = (left + right) / 2;
			if(CD[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
}
