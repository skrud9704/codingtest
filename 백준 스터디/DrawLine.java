package study3;

import java.io.*;
import java.util.*;

// 백준 2170 선긋기 
public class DrawLine {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		PriorityQueue<Line> lines = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			String[] s = br.readLine().split(" ");
			lines.add(new Line(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
		}
		
		int count=0, tmp=0;
		Line now = lines.poll();
		
		int start = now.start;
		int end = now.end;
		
		while(!lines.isEmpty()) {
			now = lines.poll();
			int tmpStart = now.start;
			int tmpEnd = now.end;
			
			// priority queue에 우선순위대로 들어가있기때문에
			// 다음 큐가 현재 큐의 범위 1) 안에 있는지 || 오른쪽으로 걸쳐있는지 2) 아예 다른 범위인지만 확인. 
			if(tmpStart <= end) {	
				if(tmpEnd > end)	// tmpEnd가 더 크다면 end를 갱신해서 범위를 넓혀줌.
					end = tmpEnd;
				continue;
			}
			else {					// 아예 다른 범위인 경우 - 지금까지 길이 count하고, 새 범위 갱신.
				tmp = end - start;
				count += Math.abs(tmp);
				start = tmpStart;
				end = tmpEnd;
			}
		}
		
		// 마지막 count
		tmp = end - start;
		count += Math.abs(tmp);
		
		System.out.println(count);
		
	}
	
	
	private static class Line implements Comparable<Line>{
		int start, end;
		
		Line(int x, int y){
			this.start = x;
			this.end = y;
		}
		
		@Override
		public int compareTo(Line o) {	
			if(this.start == o.start) 	// start 가 같다면 end가 더 작은 것이 먼저.
				return this.end-o.end < 0 ? -1 : 1;
			else						// start 가 다르다면 start가 더 작은 것이 먼저.
				return this.start - o.start < 0 ? -1 : 1;
		}
	}
}
