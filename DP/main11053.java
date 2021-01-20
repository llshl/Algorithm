package DP;

import java.io.IOException;
import java.util.Scanner;

public class main11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				//dp[i] < dp[j]+1�� �ǹ̴� �ڱ⺸�� ���� dp�� �߿��� ���� ū���� +1�� �ؼ� ���� �ְٴٴ°�
				if(arr[j] < arr[i] && dp[i] < dp[j]+1) {	//�� ���� ���ڰ� �� ū���(�����ϴ°��)
					dp[i] = Math.max(dp[i], dp[j]+1);
					//dp[i] = dp[j]+1;
				}
			}
		}
		int max = -1;
		for(int i=0;i<N;i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
