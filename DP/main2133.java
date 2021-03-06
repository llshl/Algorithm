package DP;

import java.util.Scanner;

public class main2133 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[31];
		dp[0] = 1;
		for(int i=2;i<=N;i+=2) {
			dp[i] = dp[i-2]*3;
			for(int j=i-4;j>=0;j-=2) {
				dp[i] += dp[j]*2;
			}
		}
		System.out.println(dp[N]);
	}
}
