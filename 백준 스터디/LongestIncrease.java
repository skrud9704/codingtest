package study4;

import java.io.*;
import java.util.ArrayList;

// 백준 12015번 가장 긴 증가하는 부분 수열2
// 1,2,3,4차시도 : 틀림
// 5차 시도 : 성공. increase size가 1일 때도 1 출력해야함. 0 출력 안됨. 

//ex. 10 20 40 45 50 55 25 17 18
//10 20 40 45 50 55

//10 17 18 45 50 55
//ex. 10 20 40 45 25 17 18 23 30 35 37
//10 17 18 23 30 35 37

//지워나간다고 생각
//칠판에 입력순서대로 쓴다고 생각해보면
//다음 숫자가 크면 계속 쓰고,
//더 작다면 그것보다 겨우 큰 위치부터 다시 쓰기 시작해서 결국 길이가 더 긴것을 찾는다고 보면 됨.
//현재 알고리즘대로 하면 길이는 정확하나 실제 최적 배열과는 달라짐.
public class LongestIncrease {
	
	private static int[] arr;
	private static ArrayList<Integer> increase;
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1~100만
		arr = new int[N];					// 원소 1~100만
		String[] s= br.readLine().split(" ");
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(s[i]);
		
		increase = new ArrayList<>();
		increase.add(arr[0]);
		
		for(int i=1;i<N;i++) {
			if(arr[i] > increase.get(increase.size()-1)) {
				increase.add(arr[i]);
			}else if(arr[i] < increase.get(increase.size()-1)) {
				increase.set(lowerBound(arr[i]), arr[i]);
			}
		}

		System.out.println(increase.size());		
	}
	
	private static int lowerBound(int value) {
		int start = 0, end = increase.size()-1;
		while(start < end) {
			int mid = (start+end)/2;
			if(value <= increase.get(mid)) 
				end = mid;
			else
				start = mid+1;
		}
		return start;
	}
		
}
