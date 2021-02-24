package study6;

import java.io.*;
import java.util.*;

// 백준 13549 숨바꼭질3
public class HideAndSeek {
	
	private static int[] time;
	private static boolean[] visited;
	private static int MAX = 100001;
	
	public static void main(final String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s= br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		time = new int[MAX];	// 1~10만
		visited = new boolean[MAX];	// 1~10만
		Arrays.fill(time, MAX);
		
		time[N] = 0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		
		pq.offer(new Data(N,0));
		
		while(!pq.isEmpty()) {
			
			Data now = pq.poll();
			visited[now.position]=true;

			if(now.position==K)
				break;

			
			// 경우 : +1 / -1 / *2 
			if(now.position+1 < MAX && !visited[now.position+1] 
					&& time[now.position+1] > time[now.position] + 1) {
				time[now.position+1] = time[now.position]+1;
				pq.offer(new Data(now.position+1, time[now.position+1]));
			}
			
			if(now.position > 0 && !visited[now.position-1] 
					&& time[now.position-1] > time[now.position] + 1) {
				time[now.position-1] = time[now.position]+1;
				pq.offer(new Data(now.position-1,time[now.position-1]));
			}
			
			if(now.position*2 < MAX && !visited[now.position*2] 
					&& time[now.position*2] > time[now.position]) {
				time[now.position*2] = time[now.position];
				pq.offer(new Data(now.position*2,time[now.position*2]));
			}
			
		}
		
		System.out.println(time[K]);
	}
	
	private static class Data implements Comparable<Data>{
		int position, time;
		Data(int position, int time){
			this.position = position;
			this.time = time;
		}
		@Override
		public int compareTo(Data o) {
			return this.time - o.time;
		}
		
	}

}
