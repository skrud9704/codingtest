package study4;

import java.io.*;
import java.util.*;

// 백준 1365 꼬인 전깃줄 
// 1차 시도 : 성공 - 가장긴증가하는수열2와 같은 문제.
public class TwistedWire {
	
	private static ArrayList<Integer> dontCut;
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] wire = new int[Integer.parseInt(br.readLine())];
		String[] s= br.readLine().split(" ");
		for(int i=0;i<wire.length;i++) 
			wire[i] = Integer.parseInt(s[i]);
		
		
		dontCut = new ArrayList<>();
		dontCut.add(wire[0]);
		for(int i=1;i<wire.length;i++) {
			if(wire[i] > dontCut.get(dontCut.size()-1)) 
				dontCut.add(wire[i]);
			else 
				dontCut.set(findCutPosition(wire[i]),wire[i]);
			
		}
		
		int answer = wire.length-dontCut.size();
		System.out.println(answer);
	}
	
	// lowerBound를 찾는다
	private static int findCutPosition(int value) {	
		int start = 0, end = dontCut.size()-1;
		while(start < end) {
			int mid = (start+end)/2;
			if(dontCut.get(mid) < value) {
				start = mid+1;
			}else {
				end = mid;
			}
		}
		return start;
	}
}
