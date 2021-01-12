package study2;

import java.io.*;
import java.util.*;

// DFS 백준 2606번 바이러스 
public class Virus {
	
	public static int count=0;
	
	public static void solution(ArrayList<ArrayList<Integer>> network, boolean[] visited, Stack<Integer> s) {
		
		int size = network.get(s.peek()).size();

		for(int i=0;i<size;i++) {
			if(visited[network.get(s.peek()).get(i)]) {
				continue;
			}else {
				//System.out.println("방문합니다 "+s.peek()+"의 인접컴퓨터"+network.get(s.peek()).get(i));
				visited[network.get(s.peek()).get(i)] = true;
				s.push(network.get(s.peek()).get(i));
				count++;
				solution(network,visited,s);
			}
		}
		
		s.pop();
		
		//System.out.println("모두 방문했으므로 "+s.pop()+"을 POP");
				
		if(s.isEmpty()) {
			System.out.println(count);
		}
			
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int comNum = Integer.parseInt(br.readLine());
		int pairNum = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> network = new ArrayList<ArrayList<Integer>>();
		
		
		for(int i=0;i<comNum+1;i++) {
			network.add(new ArrayList<Integer>());	// 컴퓨터 수 +1 만큼 생성 (1-base) 
		}
		
		boolean[] visited = new boolean[comNum+1];
		
		for(int i=0;i<pairNum;i++) {
			String[] s = br.readLine().split(" ");
			network.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
			network.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
		}
		
		Stack<Integer> s = new Stack<>();
		
		s.push(1);
		visited[1]=true;
		
		
		/*for(int i=0;i<network.size();i++) {
			for(int j=0;j<network.get(i).size();j++) {
				System.out.print(network.get(i).get(j)+" ");
			}
			System.out.println();
		}*/
		
		solution(network,visited,s);
	}
}
