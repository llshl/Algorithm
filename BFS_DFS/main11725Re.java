package BFS_DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class main11725Re {
	public static int N;
	public static boolean[] visited;
	public static int[] ans;
	public static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N+1];
		list = new ArrayList<>();
		ans = new int[N+1];
		for(int i=0;i<N;i++) {				  //0������ 7������	//��尡 7���� 1~7����尡 ������ 7���� �־�����Ѵ�
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<N-1;i++) {		//N-1�� ����
			int temp1 = sc.nextInt();
			int temp2 = sc.nextInt();
			list.get(temp2).add(temp1);
			list.get(temp1).add(temp2);
		}
		dfs(1);
		for(int i=1;i<ans.length;i++) {	//2������ ������ 0���ε������� �ƹ��͵� ����(0������ ���� 1�������� �����ϱ�) 1���ε����� 1������� �θ�� �ƹ��͵� ���⿡ �Ⱦ���
			System.out.println(ans[i]);
		}
	}

	private static void dfs(int index) {
		visited[index] = true;
		for(int i : list.get(index)) {	
			if(visited[i] == false) {
				ans[i] = index;		//1������� �ڽ����δ� 6,4�ε� �̷��� �Ǹ� ans[6] = 1, ans[4] = 1�� �ȴ� �� 6���� �θ�� 1 4���� �θ�� 1�̶�� �Ҹ�
				dfs(i);
			}
		}
	}
}
