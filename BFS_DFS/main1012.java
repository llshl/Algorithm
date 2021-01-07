package BFS_DFS;

import java.util.Scanner;

public class main1012 {
	public static int T;
	public static int M;	//����(��)
	public static int N;	//����(��)
	public static int K;	//���� ����
	public static int cnt=0;	//��
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};	//�����¿�
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0;i<T;i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][M];
			for(int i1=0;i1<K;i1++) {
				int tempX = sc.nextInt();	//����(��)
				int tempY = sc.nextInt();	//����(��)
				arr[tempY][tempX] = 1;
			}
			for(int i1=0;i1<N;i1++) {
				for(int j=0;j<M;j++) {
					if(arr[i1][j] == 1) {
						dfs(i1,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			cnt=0;
		}
	}
	
	private static void dfs(int x, int y) {	//x�� ����, y�� ����
		arr[x][y] = 0;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny<0 || nx>=N || ny>=M) {	//���� �����¿찡 �ǹٸ� �����ϰ��
				continue;
			}
			else {
				if(arr[nx][ny] == 1) {
					dfs(nx,ny);
				}
			}
		}
	}
}
