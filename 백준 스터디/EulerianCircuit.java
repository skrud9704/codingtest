package study2;

import java.io.*;
import java.util.*;


// DFS 백준 1199 오일러회로
// 1차 시도 : 시간 초과 재귀와 스택, 어레이리스트 접근하는 상수시간 때문인 듯 (solution)
// 2차 시도 : 틀림 이유는 solution2의 두번째 주석 참고
// 3차 시도 : 정답 
public class EulerianCircuit {
	
	public static Stack<Integer> s = new Stack<>();
	public static ArrayList<Integer> trace = new ArrayList<>();
	
	public static void solution(int[][] matrix) {
		
		for(int i=0; i < matrix[s.peek()-1].length; i++) {
			if(matrix[s.peek()-1][i]!=0) {	// 간선이 있다는 의미 
				trace.add(i+1);
				
				matrix[s.peek()-1][i]--;
				matrix[i][s.peek()-1]--;
				
				s.push(i+1);
				
				solution(matrix);
			}
		}
		
		s.pop();
		
		if(s.isEmpty() && trace.get(0)==trace.get(trace.size()-1))
			for(int answer : trace)
				System.out.print(answer+" ");
		
	}
	
	public static void solution2(int[][] matrix, int start) {
		for(int i=0; i < matrix[start].length; i++) {
			if(matrix[start][i]!=0) {	// 간선이 있다는 의미
				
				matrix[start][i]--;
				matrix[i][start]--;
				
				solution2(matrix,i);
			}
		}
		System.out.print((start+1)+" ");	// 이 줄을 for문 위에다 적으면 안되는 이유가 무엇일까?
	}
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodeN = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[nodeN][nodeN];
		boolean isImpossible = false;
		
		for(int i=0;i<nodeN;i++) {
			String[] s = br.readLine().split(" ");
			int sum=0;
			for(int j=0;j<nodeN;j++) {
				matrix[i][j] = Integer.parseInt(s[j]);
				sum+=matrix[i][j];
			}
			if(sum%2==1)
				isImpossible = true;
		}
		
		trace.add(1);
		s.push(1);
		
		
		if(isImpossible)
			System.out.println(-1);
		else {
			//solution(matrix);
			solution2(matrix,0);
		}
			
		
	}
}
