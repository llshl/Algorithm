package BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node6{
	private int x;
	private int y;
	
	public Node6(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

public class main2667Re {
	public static int N;
	public static int cnt=0;
	public static int danjisu=0;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String temp = sc.next();
			for(int j=0;j<N;j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1) {
					danjisu++;
					list.add(dfs(i,j));
					cnt=0;
				}
			}
		}
		Collections.sort(list);
		System.out.println(danjisu);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	private static int dfs(int x, int y) {
		arr[x][y] = 2;	//�湮ǥ�ø� �׳� 0�� 1�� �ƴ� �ٸ����� ���൵ �ȴ�.
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) {	//�ϳ��� ���� �����
				continue;
			}
			if(arr[nx][ny] == 1) {
				cnt++;
				dfs(nx,ny);
			}
		}
	return cnt+1;	//�� ó�� ������ ������ ���� �ʾұ⶧��
	}
}
