package greedy;

import java.io.*;
import java.util.*;

// ���� 2891�� ī��� ��ǳ
// 1���� - ����
public class KayakAndWind {
	
	public static void solution(Team[] teams) {
		
		int dontGo = 0;
		
		for(int i=0;i<teams.length;i++) {
			if(!teams[i].isCrash || teams[i].haveSpare)
				continue;
			// ī���� �ջ�ǰ�, ���� ���� �� -> �� �� ���� ����
			// �� �� 
			if(i!=0 && teams[i-1].haveSpare && !teams[i-1].isCrash && !teams[i-1].lentOther) {
				teams[i-1].lentOther=true;
				continue;
			}
			// �� �� 
			if(i!=teams.length-1 && teams[i+1].haveSpare && !teams[i+1].isCrash && !teams[i+1].lentOther) {			
				teams[i+1].lentOther=true;
				continue;
			}
			
			dontGo++;
		}
		
		System.out.println(dontGo);
	}

	public static class Team{
		boolean isCrash =false;
		boolean haveSpare =false;
		boolean lentOther =false;
		
		public Team() {}
	}
	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int S = Integer.parseInt(s1[1]);
		int R = Integer.parseInt(s1[2]);
		Team[] teams= new Team[N];
		for(int i=0;i<N;i++) {
			teams[i] = new Team();
		}
		
		String[] s2 = br.readLine().split(" ");
		for(int i=0;i<S;i++) {
			teams[Integer.parseInt(s2[i])-1].isCrash = true;
		}
		
		String[] s3 = br.readLine().split(" ");
		for(int i=0;i<R;i++) {
			teams[Integer.parseInt(s3[i])-1].haveSpare = true;
		}
		
		solution(teams);
	}
}
