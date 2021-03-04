package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1717 집합의 표현 
public class RepresentSet {
	
	private static int[] parent;
	
	public static void main(final String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s1= br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int M = Integer.parseInt(s1[1]);
		
		parent = new int[N+1];		// index : num, value : parent
		for(int i=0;i<N+1;i++) 
			parent[i] = i;
		
		
		for(int i=0;i<M;i++) {
			String[] s2 = br.readLine().split(" ");
			int type = Integer.parseInt(s2[0]);
			int a=Integer.parseInt(s2[1]);
			int b=Integer.parseInt(s2[2]);
			if(type==0) {
				if(a!=b)
					unionParent(a,b);
			}else {
				if(findParent(a)!=findParent(b)) 
					System.out.println("NO");
				else
					System.out.println("YES");
			}
		}
	}
	
	private static int findParent(int num) {
		if(parent[num]!=num)
			return parent[num]=findParent(parent[num]);
		return num;
	}
	
	private static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a>b)
			parent[a]=b;
		else
			parent[b]=a;
	}
	

}
