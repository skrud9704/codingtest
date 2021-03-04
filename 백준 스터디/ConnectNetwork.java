package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 그냥 배열말고 프라이머리큐로도 풀 수 있음. 
public class ConnectNetwork {
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());		// 1~1000대 
		int M = Integer.parseInt(br.readLine());		// 1~10만개 
		
		int[] computers = new int[N+1];
		for(int i=0;i<N+1;i++)
			computers[i]=i;
		
		Data[] networks = new Data[M];
		
		for(int i=0;i<M;i++) {
			String[] s = br.readLine().split(" ");
			networks[i] = new Data(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
		}
		
		Arrays.sort(networks);
		
		int answer = 0;
		
		for(int i=0;i<M;i++) {
			if(networks[i].a!=networks[i].b) {
				if(findParent(computers, networks[i].a) == findParent(computers, networks[i].b)) 
					continue;
				
				unionParent(computers,networks[i].a,networks[i].b);
				answer += networks[i].c;
			}
			
		}
		
		System.out.println(answer);
		
	}
	
	private static class Data implements Comparable<Data>{
		int a, b, c;
		
		Data(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Data o) {
			if(this.c < o.c)
				return -1;
			else
				return 1;
		}
		
	}
	
	private static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		
		if(a > b)
			parent[a] = b;
		else
			parent[b] = a;
		
	}
	
	private static int findParent(int[] parent, int num) {
		if(parent[num]!=num)
			parent[num]=findParent(parent,parent[num]);
		
		return parent[num];
		
	}

}
