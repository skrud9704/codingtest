package study8;

import java.io.*;
import java.util.*;

// 백준 20040 사이클 게임 
public class CycleGame {
	
	private static int[] parent;
	
	public static void main(final String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());		// 3~50만 
		int M = Integer.parseInt(st.nextToken());		// 3~100만 
		
		parent = new int[N];
		for(int i=0;i<N;i++)
			parent[i] = i;
		
		int cycle = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int o1 = Integer.parseInt(st.nextToken());
			int o2 = Integer.parseInt(st.nextToken());
			
			if(unionParent(o1,o2)) {
				cycle = i+1;
				break;
			}
		}
		
		System.out.println(cycle);
		
	}
	
	private static int findParent(int num) {
		if(num!=parent[num])
			parent[num] = findParent(parent[num]);
		
		return parent[num];
	}
	
	private static boolean unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a==b)
			return true;
		else {
			if(a > b)
				parent[a] = b;
			else
				parent[b] = a;
			return false;
		}
		
	}

}
