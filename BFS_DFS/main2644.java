package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main2644 {
	public static int n;	//��ü�����
	public static int a,b;	//�λ������ �̼�
	public static int m;	//�����
	public static int ans;
	public static int cnt=0;
	public static int[] chon;
	public static boolean[] visited;
	public static int[][] arr = new int[101][101]; 	//��������迭
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//�����
		a = sc.nextInt();
		b = sc.nextInt();
		m = sc.nextInt();	//�����
		chon = new int[n+1];
		visited = new boolean[n+1];
		for(int i=1;i<m+1;i++) {
			int tempX = sc.nextInt();
			int tempY = sc.nextInt();
			arr[tempX][tempY] = arr[tempY][tempX] = 1;	//��������
		}
		//arr[a][b] = arr[b][a] = 5;
		bfs(a);
		System.out.println(ans);
		

	}
	private static void bfs(int index) {
		Queue<Integer> q = new LinkedList<>();
		chon[index] = 0;	//�ڽŰ� 0���ε� �ϴ� �湮ó������ 1���� �信�� -1����
		q.add(index);
		while(!q.isEmpty()) {
			index = q.poll();
			if(visited[index] == false) {	//�湮���ѳ����
				visited[index] = true;
				for(int i=1;i<n+1;i++) {		//1~9(n�����)
					if(arr[index][i] == 1 && visited[i] == false) {
						q.add(i);
						chon[i] = chon[index] + 1; //1�� ���
					}
					if(index == b){		//�� ������ ��ǥ��忡 �ٴٶ�����
						ans = chon[index];
						return;
					}
				}
			}
		}
		ans = -1;
	}
}
