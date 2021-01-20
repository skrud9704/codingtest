package study3;

import java.util.*;
import java.io.*;

// 백준 1260 dfs와 bfs
public class DfsBfs {
	
	private static ArrayList<ArrayList<Integer>> graph;
	private static HashSet<Integer> visited;
	
	private static void dfs(int start) {
		Stack<Integer> s = new Stack<>();
		visited = new HashSet<Integer>();
		s.add(start); 
		visited.add(start);
		
		System.out.print(start+" ");
		while(!s.isEmpty()) {
			boolean noNode = true;
			for(int i=0;i<graph.get(s.peek()).size();i++) {
				int nextNode = graph.get(s.peek()).get(i);
				if(!visited.contains(nextNode)) {
					s.add(nextNode);
					visited.add(nextNode);
					noNode=false;
					System.out.print(nextNode+" ");
					break;
				}
			}
			if(noNode)
				s.pop();
		}
		
		System.out.println();
	}
	
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited = new HashSet<Integer>();
		q.add(start); 
		visited.add(start);
		
		System.out.print(start+" ");
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				if(!visited.contains(graph.get(now).get(i))){
					q.add(graph.get(now).get(i));
					visited.add(graph.get(now).get(i));
					System.out.print(graph.get(now).get(i)+" ");
				}
			}
		}
		System.out.println();
	}
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int M = Integer.parseInt(s1[1]);
		int V = Integer.parseInt(s1[2]);
		
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i < N+1; i++) {	// index 1-base
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			String[] s2 = br.readLine().split(" ");
			graph.get(Integer.parseInt(s2[0])).add(Integer.parseInt(s2[1]));
			graph.get(Integer.parseInt(s2[1])).add(Integer.parseInt(s2[0]));
		}
		
		for(int i=1;i <= N; i++) {	// 정점번호가 작은 순으로 방문하기 위해 sort 
			Collections.sort(graph.get(i));
		}
		
		
		dfs(V);
		bfs(V);
		
	}
}
