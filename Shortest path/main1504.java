package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node9 implements Comparable<Node9>{

	private int distance;
	private int index;
	
	public Node9(int index, int distance) {
		super();
		this.distance = distance;
		this.index = index;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public int compareTo(Node9 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class main1504 {

	public static int N,E;
	public static int INF = (int)1e9;
	public static int[] d1;
	public static int[] d2;
	public static int[] d3;
	public static ArrayList<ArrayList<Node9>> graph = new ArrayList<ArrayList<Node9>>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		d1 = new int[N+1];
		d2 = new int[N+1];
		d3 = new int[N+1];
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<Node9>());
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node9(b,c));
			graph.get(b).add(new Node9(a,c));	//����� �׷����̹Ƿ� �ݴ�ε� �̾���
		}
		Arrays.fill(d1, INF);
		Arrays.fill(d2, INF);
		Arrays.fill(d3, INF);
		st = new StringTokenizer(br.readLine()," ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());	//���ľ��ϴ� ������ ��ȣ(�ε���)
		//1��(��������)���� v1���� ���ͽ�Ʈ��, v1���� v2���� ���ͽ�Ʈ��, v2���� N��(����������)���� ���ͽ�Ʈ�� �� 3��
		
		dijkstra(1,d1);		//1�� v1 Ȥ�� v2
		dijkstra(v1,d2);	//v1���� v2 Ȥ�� end
		dijkstra(v2,d3);	//v2���� v1 Ȥ�� end
		
		int startTov1 = d1[v1];	//�������� -> v1 �ּҰŸ�
		int startTov2 = d1[v2];	//�������� -> v2 �ּҰŸ�
		
		int v1Tov2 = d2[v2];	//v1 -> v2 , v2 -> v1 �ּҰŸ��� ����.
		
		int v1Toend = d2[N];	//v1 -> end �ּҰŸ�
		int v2Toend = d3[N];	//v2 -> end �ּҰŸ�
		
		int ans = Math.min(startTov1 + v1Tov2 + v2Toend, startTov2 + v1Tov2 + v1Toend);
		//�ϳ��� ������������ -1
		if((startTov1 == INF) || (startTov2 == INF) || (v1Tov2 == INF) || (v1Toend == INF) || (v2Toend == INF)) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	
	
	private static void dijkstra(int start, int[] d) {
		PriorityQueue<Node9> pq = new PriorityQueue<Node9>();
		boolean[] visit = new boolean[N+1];
		d[start] = 0;
		pq.offer(new Node9(start,0));
		while(!pq.isEmpty()) {
			Node9 node = pq.poll();
			int dist = node.getDistance();	//�����Ÿ�
			int now = node.getIndex();	//���� ��ġ ����
			if(visit[now] == false) {
				visit[now] = true;
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();
					if(d[graph.get(now).get(i).getIndex()] > cost) {
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node9(graph.get(now).get(i).getIndex(),cost)); 
					}
				}
			}
		}
	}
}
