package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main11725 {
	public static int N;
	public static int end;
	public static ArrayList<ArrayList<Integer>> tree;
	public static int[] ans;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		tree = new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			tree.add(new ArrayList<>());	//N�� ��尳��. n=7�̸� ��尡 7�������� ������ i<N+1�����ؾ� 7�������� ���´�
		}
		ans = new int[N+1];
		
		for(int i=1;i<N;i++) {
			String[] temp = br.readLine().split(" ");
			tree.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
			tree.get(Integer.parseInt(temp[1])).add(Integer.parseInt(temp[0]));
		}
		
		dfs(1);	//�׻� 1���� Ž�� ����
		
		for(int i=2;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
	private static void dfs(int index) {
		visited[index] = true;
		for(int i : tree.get(index)) {
			if(visited[i] == false) {	//4�� �Ȱ�������
				ans[i] = index;		//ans[4] = �� �θ��� index�� �ִ´�
				dfs(i);				//�ڽ��� �θ�� �ؼ� �ٽ� ����
			}
		}
	}
}
