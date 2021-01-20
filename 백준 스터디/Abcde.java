package study2;

import java.io.*;
import java.util.*;


// DFS 백준 13023 ABCDE
// 1차 시도 : 틀림 
// 2차 시도 : 시간 초과
// 3차 시도 : 틀림
// 4차 시도 : 성공. 시작점을 여러번 주어야한다는 것 간과.
public class Abcde {
	
	public static void solution(ArrayList<ArrayList<Integer>> graph, Stack<Integer> s) {
		for(int i=0;i<graph.get(s.peek()).size();i++) {
			if(!s.contains(graph.get(s.peek()).get(i))) {
				s.push(graph.get(s.peek()).get(i));
				if(s.size()==5) {
					System.out.println(1);
					System.exit(0);
				}
				solution(graph,s);
			}
		}
		
		s.pop();
		
	}

	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);	// 사람 수 5~2000
		int M = Integer.parseInt(s1[1]);	// 관계 수 1~2000
		
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			String[] s2 = br.readLine().split(" ");
			graph.get(Integer.parseInt(s2[0])).add(Integer.parseInt(s2[1]));
			graph.get(Integer.parseInt(s2[1])).add(Integer.parseInt(s2[0]));
		}
		
		for(int i=0;i<N;i++) {
			Stack<Integer> s = new Stack<>();
			s.push(i);
			solution(graph,s);
		}
		
		System.out.println(0);
		
	}
}
