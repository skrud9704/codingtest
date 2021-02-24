package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2252 줄 세우기 
// 성공. 시간줄이기
// 1. 조건문 변경 
// 2. visited배열 삭제
// 3. parseInt 최소한만 동작하도록
// 4. stringbuilder 사용 
// 5. stringtokenizer 사용 
public class LineUp {
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		int[] ins = new int[N+1];
		
		for(int i=1;i<N+1;i++)
			graph[i] = new ArrayList<>();
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			ins[b]++;
		}
		
		Queue<Integer> tp = new LinkedList<>();
		
		for(int i=1;i<N+1;i++)
			if(ins[i]==0) 
				tp.add(i);
				
		
		StringBuilder sb = new StringBuilder();
		while(!tp.isEmpty()) {
			
			int now = tp.poll();
			sb.append(now).append(" ");
			
			for(int i=0;i<graph[now].size();i++) {
				int end = graph[now].get(i);
				ins[end]--;
				//if(!tp.contains(end) && !visited[end] && ins[end]==0)
				if(ins[end]==0)
					tp.offer(end);
			}
			
		}
	
		System.out.println(sb);
		
		
	}

}
