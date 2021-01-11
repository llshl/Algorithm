package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node14{
	private int x;
	private int y;
	public Node14(int x, int y){
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

public class main14502 {
	public static int N;
	public static int M;
	public static int ans=-1;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//1.dfs�� �� 3�� ����� ��� ã��(���� ����� dfs�� 2�� �����)
		//2.���� ���¿��� bfs�� ���̷��� ������
		//3.Ȯ�θ޼���� �������� ��������
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {	//���� ����� �ִ°��̶��
					arr[i][j] = 1;		//���� �����
					dfs(1);
					arr[i][j] = 0;	//dfs - bfs���� �� �ٽ� �� �����ֱ�
				}
			}
		}
		System.out.println(ans);
	}
	private static void dfs(int cnt) {	//cnt�� dfs 3������ �ؼ� �� 3���� ����� bfs�� �Ѿ�� ī��Ʈ, dfs���� ���Խ� �̹� 1�̴�.
		if(cnt == 3) {	//�� 3�� ������ٸ�
			bfs();
			//cnt=0;
			return;	//main�� dfs�������� �ٽ� ����
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {	//���� ����� �ִ°��̶��
					arr[i][j] = 1;		//���� �����
					dfs(cnt+1);
					arr[i][j] = 0;	//dfs - bfs���� �� �ٽ� �� �����ֱ�
				}
			}
		}
		
	}
	private static void bfs() {
		//�� ���� �迭�� ���� ���縦 ���ؼ� �ϳ� ������� �װɷ� bfs��������
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {		//map�迭�� bfs
			for(int j=0;j<M;j++) {
				map[i][j] = arr[i][j];
			}
		}
		Queue<Node14> q = new LinkedList<>();
		for(int i=0;i<N;i++) {		//map�迭�� bfs
			for(int j=0;j<M;j++) {
				if(map[i][j] == 2) {
					q.add(new Node14(i,j));	//���̷����� ��ġ�� �ϴ� �� ť�� �ְ�
				}
			}
		}
		while(!q.isEmpty()) {
			Node14 node = q.poll();
			int x = node.getX();
			int y = node.getY();
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(map[nx][ny] == 1) {	//���̶��
					continue;
				}
				else {
					map[nx][ny] = 1;	//������ �ع����� �湮ó�� ������ ���������δ� 0�� �κ� ������ �˸�Ǵϱ�
					q.add(new Node14(nx,ny));
				}
			}
		}
		isAnswer(map);  //�� �迭�� 0�� ������ ����� �ľ��ϰ� �� �߿��� max���� �����Ͽ� ��ȯ		
	}
	private static void isAnswer(int[][] map) {
		int max = 0;
		for(int i=0;i<N;i++) {		
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					max++;
				}
			}
		}
		if(ans <= max) {	//max�� ����
			ans = max;
		}
	}
}
