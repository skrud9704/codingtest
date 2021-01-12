package study2;

import java.io.*;
import java.util.*;


// 백준 14867 물통
public class WaterBucket {

	private static class Bucket{
		int volume;
		int goal;
		int now;
		
		Bucket(int volume, int goal){
			this.volume = volume;
			this.goal = goal;
			this.now=0;
		}
	}
	
	private static void F(Bucket bucket) {
		bucket.now = bucket.volume;
	}
	
	private static void E(Bucket bucket) {
		bucket.now = 0;
	}
	
	private static void M(Bucket a,Bucket b) {
		if(a.now <= b.volume-b.now) {
			b.now+=a.now;
			a.now=0;
		}else {
			b.now=b.volume;
			a.now-=b.volume;
		}
	}
	
	private static void solution(Bucket A, Bucket B) {
		
	}
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		Bucket A = new Bucket(Integer.parseInt(s[0]),Integer.parseInt(s[2]));
		Bucket B = new Bucket(Integer.parseInt(s[1]),Integer.parseInt(s[3]));
		
		solution(A,B);
	}
}
