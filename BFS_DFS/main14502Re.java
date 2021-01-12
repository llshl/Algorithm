package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Node15{
	private int x;
	private int y;
	
	public Node15(int x, int y) {
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


public class main14502Re {
	public static int N;
	public static int M;
	public static int ans=-1;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {-0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		//1.dfs�� �� 3�� ����� ��� ��� ����
		//2.�� ��츶�� bfs�� ���̷��� ��Ʈ����
		//3.��Ʈ�������� �����������ϱ�
		for(int i=0;i<N;i++) {	//���⼭ �� �Ѱ��� ����� dfs ���� ������ ���⼭ ������⸦ �����ؾ� ��� �������� �������� �ִ�
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {	//���� ���� �� ������
					arr[i][j] = 1;
					dfs(1);
					arr[i][j] = 0;	//�ٽ� �� ���������
				}
			}
		}
		System.out.println(ans);
	}
	
	private static void dfs(int cnt) {
		if(cnt == 3) {	//���� 3���� �Ѵٸ� bfs����
			bfs();
			return;
		}
		else {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j] == 0) {	//���� ���� �� ������
						arr[i][j] = 1;
						dfs(cnt+1);
						arr[i][j] = 0;	//�ٽ� �� ���������
					}
				}
			}
		}
		
	}
	private static void bfs() {
		//���� arr���� ���� 3�� �����������Ƿ� �� ���¿��� ���̷����� ��������.
		Queue<Node15> q = new LinkedList<>();
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 2) {
					q.add(new Node15(i,j)); //���̷��� ��ġ�� ť�� �ִ´�
				}
				map[i][j] = arr[i][j];	//�� ������ ������ ���� ����
			}
		}
		while(!q.isEmpty()) {
			Node15 node = q.poll();
			int x = node.getX();
			int y = node.getY();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(map[nx][ny] == 1) {
					continue;
				}
				else if(map[nx][ny] == 0){
					q.add(new Node15(nx,ny));
					map[nx][ny] = 1;	//�湮ó���� 1���Ѵ�.
				}
			}
		}
		isMax(map);	//���������� �ִ븦 ���ϴ� �Լ�
	}

	private static void isMax(int[][] map) {
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					count++;
				}
			}
		}
		if(count >= ans) {
			ans = count;
		}
		count = 0;
	}
}



