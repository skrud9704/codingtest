package study6;

import java.io.*;
import java.util.*;

// 백준 1753번 최단경로
public class ShortestPath {
	
	private static final int INF = Integer.MAX_VALUE;
	private static ArrayList<ArrayList<Node>> graph;	// List<Node>[] 이런식으로 해도됨.
	private static PriorityQueue<Node> pq;
	private static int[] shortestPath;
	private static int start;
	
	static class Node implements Comparable<Node>{
		int index, weight;
		Node(int index, int weight){
			this.index = index;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	
	public static void main(final String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		
		int V= Integer.parseInt(s1[0]);	// 정점 1~2만개
		int E = Integer.parseInt(s1[1]);	// 간선 1~30만개
		start = Integer.parseInt(br.readLine());	// 시작노드
		
		shortestPath = new int[V+1];
		Arrays.fill(shortestPath, INF);
		shortestPath[start] = 0;
		
		pq = new PriorityQueue<>();
		graph = new ArrayList<ArrayList<Node>>();
		for(int i=0;i<V+1;i++) {	// 정점 +1 만큼 그래프 초기화 (1-base index) 
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0;i<E;i++) {
			String[] s2 = br.readLine().split(" ");	// u v w
			graph.get(Integer.parseInt(s2[0]))
				.add(new Node(Integer.parseInt(s2[1]), Integer.parseInt(s2[2])));
		}
		
		dijkstra();
	}
	
	private static void dijkstra() {
		
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			for(int i=0; i<graph.get(now.index).size();i++) {
				int startV = now.index;
				int endV = graph.get(startV).get(i).index;
				int weight = graph.get(startV).get(i).weight;
				
				if(shortestPath[endV] > shortestPath[startV] + weight) {
					shortestPath[endV] = shortestPath[startV] + weight;
					pq.offer(new Node(endV, shortestPath[startV] + weight));
				}
			}
			
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<shortestPath.length; i++) {
			int result = shortestPath[i];
			if(result==Integer.MAX_VALUE) 
				sb.append("INF");				
			else
				sb.append(result);
			
			if(i!=shortestPath.length) {
				sb.append("\n");	
			}
		}
		
		System.out.println(sb.toString());
	}
	
	
}
