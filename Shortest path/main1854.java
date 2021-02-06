package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node14 implements Comparable<Node14>{

	private int index;
	private int distance;
	
	public Node14(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Node14 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class main1854 {

	public static int n,m,k,temp;
	public static int[] d;
	public static ArrayList<ArrayList<Node14>> graph = new ArrayList<ArrayList<Node14>>();
	public static PriorityQueue<Integer>[] countK;	//
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		d = new int[n+1];
		countK = new PriorityQueue[n+1];
		
		for(int i=0;i<=n;i++) {	//graph�ʱ�ȭ
			graph.add(new ArrayList<Node14>());
		}
		
		for(int i=0;i<=n;i++) {	//countK�ʱ��
			countK[i] = new PriorityQueue<>(k);	//�迭�� �� �ε������� ũ�� k�� pq�� �ʱ�ȭ
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node14(b,c));
		}
		Arrays.fill(d, Integer.MAX_VALUE); 
		dijkstra(1);
		//�ִܰ�ξ����� -1
		//countK�迭���� �� �ε��������� pq�� peek�� -1 ���ؼ� ���
		for(int i=1;i<=n;i++) {
			if(countK[i].size() == k) {
				System.out.println(countK[i].peek() * (-1));	//������ -1���ؼ� ���������̾����Ƿ� �ٽ� ���ؼ� ���� ������ �̴´�
			}
			else {
				System.out.println(-1);
			}
		}
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node14> pq = new PriorityQueue<Node14>();
		countK[start].add(0);	//
		pq.offer(new Node14(start, 0));
		while(!pq.isEmpty()) {
			Node14 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			for(int i=0;i<graph.get(now).size();i++) {
				int cost = dist + graph.get(now).get(i).getDistance();
				
				if(countK[graph.get(now).get(i).getIndex()].size() < k) {
					countK[graph.get(now).get(i).getIndex()].add(cost*(-1));	//���� ������ �� ����, -1���ؼ� ������������ �����Ұ�
					pq.add(new Node14(graph.get(now).get(i).getIndex(),cost)); 
				}
				else if(countK[graph.get(now).get(i).getIndex()].peek()*(-1) > cost) {	//kpq�� k���̻� ���� ������ k�迭 pq�� ù��° ������ ���� ���ŵ� ����� �۴ٸ� �ִ´�
					countK[graph.get(now).get(i).getIndex()].poll();	//ù��° ���� �����
					countK[graph.get(now).get(i).getIndex()].add(cost*(-1));	//�� ���� �ִ´�
					pq.add(new Node14(graph.get(now).get(i).getIndex(),cost)); 
				}
			}
		}
	}
}
