package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		if(N>=2) dp[2] = dp[1] + arr[2];
		for(int i=3;i<=N;i++) {
			dp[i] = Math.max(arr[i]+dp[i-2], arr[i]+arr[i-1]+dp[i-3]);
		}
		System.out.println(dp[N]);
	}
}
