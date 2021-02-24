package study4;

import java.io.*;
import java.util.*;

// 백준 2143번 두 배열의 합
// 1차시도 : 실패 - 시간초과
// 2차 시도 : 실패 - 틀림. 73%
// 3차 시도 : 성공 - answer -> long으로!
public class AddTwoArray {
	
	private static long T;
	private static ArrayList<Long> sumA, sumB;
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		T = Integer.parseInt(br.readLine());

		int[] A = new int[Integer.parseInt(br.readLine())];
		String [] ai = br.readLine().split(" ");
		for(int i=0;i<ai.length;i++) 
			A[i] = Integer.parseInt(ai[i]);
		
		int[] B = new int[Integer.parseInt(br.readLine())];
		String [] bi = br.readLine().split(" ");
		for(int i=0;i<bi.length;i++) 
			B[i] = Integer.parseInt(bi[i]);
		
		sumA = new ArrayList<>();
		getPartialSum(A, sumA);
		sumB = new ArrayList<>();
		getPartialSum(B, sumB);
		
		Collections.sort(sumB);
		
		long answer = 0;
		for(Long i : sumA) {
			long value = T-i;
			int low = lowerBound(value);
			int high = upperBound(value);
			answer += high-low;
		}
		
		System.out.println(answer);
		
	}
	
	
	private static void getPartialSum(int[] arr, ArrayList<Long> sumArr) {
		for(int i=0;i<arr.length;i++){
			long sum=0;
			for(int j=i;j<arr.length;j++) {
				sum+=arr[j];
				sumArr.add(sum);
			}
		}
	}
	
	
	private static int upperBound(long value) {
		int start = 0, end = sumB.size();
		while(start < end) {
			int mid = (start+end)/2;
			if(sumB.get(mid) <= value)
				start = mid+1;
			else
				end = mid;
		}
		
		return start;
	}
	
	private static int lowerBound(long value) {
		int start = 0, end = sumB.size();
		while(start < end) {
			int mid = (start+end)/2;
			if(value <= sumB.get(mid))
				end = mid;
			else
				start = mid+1;	
		}
		
		return start;

	}
	

}
