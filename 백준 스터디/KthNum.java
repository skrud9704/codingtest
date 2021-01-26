package study4;

import java.io.*;
import java.util.*;

// 백준 7469번 K번째 수 
// 1차시도 : 시간초과 (시간 1초, 메모리 256MB) - 원인 : 내장함수 sort = O(NlogN) * Q함수호출 최대횟수 5000번(M) => M*NlogN 
// index 보존해서 sort 하고, start ~ end 사이이면 count 올리는 식으로 변경.
// 2차시도 : 틀림 - 왜.. : 범위 간과 -10억1 추가함.
public class KthNum {

	private static Data[] arr;
		
	private static class Data implements Comparable<Data>{
		int index,value;
		Data(int index, int value){
			this.index = index;
			this.value = value;
		}
		@Override
		public int compareTo(Data o) {
			return this.value-o.value;
		}
	}
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);	// 1~10만 
		int M = Integer.parseInt(s1[1]);	// 1~5천 
		arr = new Data[N+1];			// 1 base-index, 원소 -10억 ~ +10억 (int 가능)
		ArrayList<Integer> answers = new ArrayList<>();
		
		String[] s2 = br.readLine().split(" ");
		
		arr[0] = new Data(0, -(int)Math.pow(10, 9)-1);
		for(int i=1;i<N+1;i++)
			arr[i] = new Data(i,Integer.parseInt(s2[i-1]));
		
		Arrays.sort(arr);
		
		for(int i=0;i<M;i++) {
			String[] s3 = br.readLine().split(" ");
			int start = Integer.parseInt(s3[0]);
			int end = Integer.parseInt(s3[1]);
			int k = Integer.parseInt(s3[2]);
			int count=0;
			for(int j=1;j<arr.length;j++) {
				if(arr[j].index >= start && arr[j].index <=end) {
					count++;
				}
				
				if(count==k) {
					answers.add(arr[j].value);
					break;
				}
			}
		}
		
		for(int answer : answers)
			System.out.println(answer);
	}
	
	
}
