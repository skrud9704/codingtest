package study9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Good {
	
	public static void main(final String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int result=0;
		
		for(int i=0;i<N;i++) {
			int find = arr[i];
			int left=0, right=N-1;
			
			while(left<right) {
				int sum = arr[left]+arr[right];
				if(sum==find) {
					if(left!=i && right!=i) {
						result++;
						break;
					}else if(left==i) left++;
					else if(right==i) right--;
				}else if(sum<find) left++;
				else right--;
			}			
			
		}
		
		System.out.println(result);
		
		
		
	}

}
