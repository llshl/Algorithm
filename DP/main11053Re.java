package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main11053Re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			dp[i] = 1;	//�ڱ��ڽ� ��ü�� �ϴ� ���̰� 1�� �����̹Ƿ� 1�� �ʱ�ȭ�ϰ� �����Ѵ�.
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);	//dp[i]������ ������ ����ū������ +1�� ���� ���� �����ؼ� �ִ´�
				}
			}
		}
		int max = -1;
		for(int i=1;i<=N;i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
