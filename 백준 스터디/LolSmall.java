package study7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 계속 실패 : 팩토리얼에서 자꾸 / by zero 뜸. 1000! 쯤 가면 불능에 가까운 숫자라 담을 자료형이 없음.
// 방법 바꾸자.
public class LolSmall {
	
	private static int DIVIDE = 1000000007;
	private static int[] dp = new int[10001];
	
	public static void main(final String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]); // 1~1만
		int M = Integer.parseInt(s[1]); // 2~100
		dp[0]=dp[1]=1;
		
		for(int i=2;i<=N;i++) {
			dp[i] = (dp[i-1]+ (i-M >= 0 ? dp[i-M]:0))%DIVIDE;
		}
		
		System.out.println(dp[N]);
		
	}
	
	
//	private static int dfs(int a, int b) {
//		if(a==0 && b==0)
//			return dp[a][b]=0;
//		if(a==0 || b==0)
//			return dp[a][b]=1;
//		
//		if(dp[a][b]==0) 
//			dp[a][b] = (dfs(a-1,b)%DIVIDE + dfs(a,b-1)%DIVIDE)%DIVIDE;
//		
//		return dp[a][b];
//	}
//	
//	private static long[] factorial;
//	public static void main2(final String[] args) throws Exception{
//		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		
//		String[] s = br.readLine().split(" ");
//		int N = Integer.parseInt(s[0]); // 1~1만
//		int M = Integer.parseInt(s[1]); // 2~100
//		factorial = new long[N];
//		Arrays.fill(factorial, 1);
//		
//		int mMaxCount = N/M;
//		
//		// M스킬을 한번도 안쓰는 경우 1가지로 초기화
//		long answer = 1;
//		for(int i=1;i<=mMaxCount;i++) {
//			int totalSkillCount = i + (N-M*i); 
//			// 조합
//			answer += combination(totalSkillCount, i);
//		}
//		
//		//System.out.println(answer%DIVIDE);
//	}
//	
//	private static long combination(int a, int b) {
//		if(a==b || a==0 || b == 0)
//			return 1;
//		else {
//			long x = factorial(a);
//			long y = factorial(b)*factorial(a-b);
//			return x/y;
//		}
//	}
//
//	private static long factorial(int k) {
//		if(k==0 || k==1)
//			return 1;
//		
//		if(factorial[k]==1) {
//			factorial[k] = factorial(k-1) * k;
//			System.out.println(factorial[k]+" ");
//		}
//			
//		
//		return factorial[k];
//	}
}
