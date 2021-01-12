package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Shark{
	private int x;
	private int y;
	private int move;
	private int size;
	private int eat;
	public Shark(int x, int y, int move, int size, int eat){
		this.x = x;
		this.y = y;
		this.move = move;
		this.size = size;
		this.eat = eat;
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
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getEat() {
		return eat;
	}
	public void setEat(int eat) {
		this.eat = eat;
	}
	
}

public class main16236 {
	public static int N;
	public static int sharkX;
	public static int sharkY;
	public static int ans=-1;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1,0,1,0};	//�����Ͽ�
	public static int[] dy = {0,-1,0,1};
	public static Queue<Shark> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if(arr[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					q.add(new Shark(i,j,0,2,0));	//�ʱ� ����� ��ġ�� ť�� �ֱ�
				}				//x,y,move,size,eat
			}
		}
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		boolean flag = false;	//true�Ǹ� �� ���� ���� �� �̻� ���°�
		while(!q.isEmpty()) {
			Shark node = q.poll();
			int x = node.getX();
			int y = node.getY();
			int move = node.getMove();
			int size = node.getSize();
			int eat = node.getEat();
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) {	//���������� ��ŵ
					continue;
				}
				if(arr[nx][ny] > size) {	//����� ũ�Ⱑ ���� Ŭ��� ����
					continue;
				}
				if(arr[nx][ny] != 0 && arr[nx][ny] < size && visited[nx][ny] == false) {	//���� ���� ����� �մ� ĭ�� ������ ��� �Դ´�. �԰� �ٽ� �����ؾ��Ѵ�
					arr[nx][ny] = 0;	//�Ծ����Ƿ� ��ĭ���� �����
					visited = new boolean[N][N];	//�湮�迭 �ʱ�ȭ
					arr[sharkX][sharkY] = 0;	//�ʱ� �����ġ�� 0���� ���ش�
					q.clear(); //�Ծ����� �� �ڸ��������� �ٽ� �����̴�. �ٸ� ���� �����ؾ��Ѵ�.
					if(eat == size) {	//�ڱ� ũ�⸸ŭ �Ծ��ٸ� ������
						size++;
						eat = 0;
						q.add(new Shark(nx,ny,move+1,size,eat));	//�ڱ� ũ�⸸ŭ �˾ Ŀ����� eat�� 0���� �־��ش�
					}
					else {
						q.add(new Shark(nx,ny,move+1,size,eat+1));	//�԰� ��Ŀ����� eat+1�� �Ѱ��ش�
					}
				}
				if(arr[nx][ny] == 0 && visited[nx][ny] == false) {	//��ĭ�̸� �ű�� �̵�
					visited[nx][ny] = true;
					q.add(new Shark(nx,ny,move+1,size,eat));
				}
			}
			//�迭 ��ü Ȯ���Ͽ� �� ���� �� �ִ� ����Ⱑ ���ٸ� ����
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j] != 0 && arr[i][j] < size) {	//0�� �ƴϸ鼭 ���� ���� ����Ⱑ�ִٸ� ��� ����
						flag = true;
					}			
				}
			}
			if(flag == false) {
				//����
				ans = move;
				return;
			}
			flag = false;
		}
		
	}
}
