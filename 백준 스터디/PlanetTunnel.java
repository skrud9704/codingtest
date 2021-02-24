package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 백준 2887 행성터널 최소신장트리문제  
public class PlanetTunnel {
	
	private static int[] parent;
	
	private static int find(int num) {
		if(parent[num]!=num)
			parent[num] = find(parent[num]);
		
		return parent[num];
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a>b) 
			parent[a] = b;
		else 
			parent[b] = a;
		
	}
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Planet[] xSort = new Planet[N];
		Planet[] ySort = new Planet[N];
		Planet[] zSort = new Planet[N];
		PriorityQueue<Distance> distanceSort = new PriorityQueue<>();
		parent = new int[N];
		
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			xSort[i] = new Planet(i,Integer.parseInt(s[0]));
			ySort[i] = new Planet(i,Integer.parseInt(s[1]));
			zSort[i] = new Planet(i,Integer.parseInt(s[2])); 
			parent[i]=i;
		}
		
		Arrays.sort(xSort);
		Arrays.sort(ySort);
		Arrays.sort(zSort);
		
		
		for(int i=0;i<N-1;i++) {
			distanceSort.add(new Distance(xSort[i].index,xSort[i+1].index,xSort[i+1].position-xSort[i].position));
			distanceSort.add(new Distance(ySort[i].index,ySort[i+1].index,ySort[i+1].position-ySort[i].position));
			distanceSort.add(new Distance(zSort[i].index,zSort[i+1].index,zSort[i+1].position-zSort[i].position));
		}
		
		
		int answer=0;
		while(!distanceSort.isEmpty()) {
			Distance now = distanceSort.poll();
			
			if(find(now.a)!=find(now.b)) {
				union(now.a,now.b);
				answer+=now.distance;
			}
		}
		
	
		System.out.println(answer);
		
	}
	
	private static class Planet implements Comparable<Planet>{
		int index, position;
		Planet(int index, int position){
			this.index = index;
			this.position = position;
		}
		@Override
		public int compareTo(Planet o) {
			return this.position-o.position;
		}
	}
	
	private static class Distance implements Comparable<Distance>{
		int a,b,distance;
		Distance(int a,int b,int distance){
			this.a = a;
			this.b = b;
			this.distance = distance;
		}
		@Override
		public int compareTo(Distance o) {
			return this.distance-o.distance;
		}
	}

}
