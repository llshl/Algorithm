package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1149Re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[1001][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(N>1) {
			for(int i=1;i<N;i++) {
				for(int j=0;j<3;j++) {
					arr[i][j] = arr[i][j] + Math.min(arr[i-1][(j+1)%3], arr[i-1][(j+2)%3]); 
				}
			}
		}
		int min = arr[N-1][0];
		for(int i=1;i<3;i++) {
			if(min > arr[N-1][i]) {
				min = arr[N-1][i];
			}
		}
		System.out.println(min);
	}
}
