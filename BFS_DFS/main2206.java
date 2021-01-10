package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Node11{
	private int x;
	private int y;
	private int drill;
	private int move;
	private int cnt;
	public Node11(int x, int y, int drill, int move){
		this.x = x;
		this.y = y;
		this.drill = drill;
		this.move = move;
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
	public int getDrill() {
		return drill;
	}
	public void setDrill(int drill) {
		this.drill = drill;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	
	
}

public class main2206 {
	public static int N;
	public static int M;
	public static int ans = 0;
	public static int[][] arr;
	public static int[][] visited;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		if(N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		arr = new int[N][M];
		visited = new int[N][M];	//�� �μ� Ƚ��	0,1����, 2�� ���� �湮x
		for(int i=0;i<N;i++) {
			temp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);	//temp���ٹ����Ÿ� �ѱ��ھ� [0][1][2]...�̷��� ������
				visited[i][j] = 2;
			}
		}
		
		bfs(0,0);
	
		
		if(visited[N-1][M-1]!=5) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	/*�ݷʴ� ��ó�� ���ڸ������ �� ���ư��� �ְ� ������ ���. ������������ ��ٷ� �ؿ����� ���� �� �湮ó���ϸ� ���ڷ� ���ư��� �ְ� ���� ���Ѵ�
	 * 6 5
		00000
		11110
		00000
		01111
		01111
		00010
	 */
	private static void bfs(int x, int y) {
		Queue<Node11> q = new LinkedList<>();
		q.add(new Node11(x,y,0,1));	//x��ǥ, y��ǥ, ���۶���Ƚ��, �̵��Ÿ�
		visited[x][y] = 0;
		while(!q.isEmpty()) {
			Node11 node  = q.poll();
			x = node.getX();
			y = node.getY();
			int drill = node.getDrill();
			int move = node.getMove();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(nx == N-1 && ny == M-1) {	//������� ������ �̵��Ÿ�
					visited[nx][ny] = 5;	//���帮 5�� ����, �� 0,1,2 ������ �ƹ��ų�
					ans = move+1;	//move+1�ؼ� ť�� �־��ذ����� ���
					return;
				}
				//visited �迭�� �� ���� ����ϴ� ��尡 ���ݱ��� ��� ���� �վ����� Ƚ���� �ʱ�ȭ�� �迭
				//����, ���� �ѹ� �����ְ� ������ �濡�� 1�� �������ְ� �ѹ��� �ȶ��� �ְ� ��������쿡�� 0���� �������ִ�.
				//�ƹ��� �������� ��� ������ �������� visited�迭�� dafault�� 2�� ���ִ�.
				//visited�迭�� ��� ĭ�� INF(���⼭�� 2�μ���), �� 2>1�ΰ�쳪 1>0�� ��츸 ���ÿ� �� ��η� ���ļ� �����ִ�
				//2>1�� �ƹ��� �������� �濡 �����ѹ������ְ� �����Ҷ�
				//2>0�� �ƹ��� �������� �濡 ���� �ѹ��� �ȶ����ְ� �����Ҷ�
				//1>0�� ���� �ѹ������ְ� ������ �濡 ���� �ѹ��� �ȶ��� �ְ� �����Ҷ�
				//�� �̿��� ���� �����ѹ������ֵ鳢�� �������� or ���� �ѹ��� �ȶ��� �ֵ鳢�� �������� �̹Ƿ� �׳� �����ص��ȴ�. ���۶���Ƚ���� �����ֵ鳢���� �ѳ� Ž���ϴ� ��츦 ���� �ȱ�(���� �Ѵ� Ȯ���� ���ʿ� ������
				if(visited[nx][ny] > drill) {	
					if(arr[nx][ny] == 0) {	//���̶��
						visited[nx][ny] = drill;	//������
						q.add(new Node11(nx,ny,drill,move+1));
					}
					else if(arr[nx][ny] == 1) {	//���̶��
						if(drill == 0) {	//�帱 �ț��ٸ�
							visited[nx][ny] = drill+1;
							q.add(new Node11(nx,ny,1,move+1)); 	//�帱Ƚ�� 1ȸ �߰��ؼ� ť�� �߰�
						}
					}
				}
			}
		}
	}
}
