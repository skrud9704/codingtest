package study3;

import java.util.*;
import java.io.*;

// 백준 5014번 스타트링크 - BFS
public class Startlink {
	
	private static int Building,Start,Goal,Up,Down;
	private static int answer = -1;
	
	private static void solution() {
		Queue<Move> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();	
	
		q.add(new Move(0,Start));	// 현재 위치 넣기 
		visited.add(Start);
		
		while(!q.isEmpty()) {
			Move now = q.poll();
			
			if(now.floor==Goal) {
				answer=now.depth;
				return;
			}
			
			int nextUp = now.floor+Up;
			int nextDown = now.floor-Down;
			
			if(nextUp <= Building && !visited.contains(nextUp)) {
				q.add(new Move(now.depth+1,nextUp));
				visited.add(nextUp);
			}
			if(nextDown > 0 && !visited.contains(nextDown)) {
				q.add(new Move(now.depth+1,nextDown));
				visited.add(nextDown);
			}
			
		}
	}
	
	private static class Move{
		int depth, floor;
		Move(int depth, int floor){
			this.depth = depth; this.floor = floor;
		}
	}
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		Building = Integer.parseInt(s[0]);
		Start = Integer.parseInt(s[1]);
		Goal = Integer.parseInt(s[2]);
		Up = Integer.parseInt(s[3]);
		Down = Integer.parseInt(s[4]);
		
		
		solution();
		
		if(answer==-1)
			System.out.println("use the stairs");
		else
			System.out.println(answer);
		
	}
}
