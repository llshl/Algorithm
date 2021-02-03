package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node8 implements Comparable<Node8>{

	private int distance;
	private int index;
	
	public Node8(int index, int distance) {
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
	public int compareTo(Node8 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class main1238 {
	public static int N,M,X;
	public static int INF = (int)1e9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());	//���
		M = Integer.parseInt(st.nextToken());	//�Ÿ�
		X = Integer.parseInt(st.nextToken());	//����
		int[] dGo = new int[N+1];
		int[] dBack = new int[N+1];
		ArrayList<ArrayList<Node8>> graph = new ArrayList<ArrayList<Node8>>();
		ArrayList<ArrayList<Node8>> graph2 = new ArrayList<ArrayList<Node8>>();
		for(int i=0;i<=N;i++) {	//0��° ��Ҵ� ��� ���ϴϱ� <=�� ����
			graph.add(new ArrayList<Node8>());
			graph2.add(new ArrayList<Node8>());	//���� ������ �뵵 �׷���
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node8(b,c));	//a���� b�ΰ��� �Ÿ�
			graph2.get(b).add(new Node8(a,c));	//������ ������ �׷���
		}
		Arrays.fill(dGo, INF);
		Arrays.fill(dBack, INF);
		dijkstra(X,graph,dBack);	//���������� ��������� ���� �ִܰ�ε�, �Ϲ� ���ͽ�Ʈ��
		dijkstra(X,graph2,dGo);	//������ ��������� ���������� �ִܰ�ε�, ���� ������ ������ ���ͽ�Ʈ��
		
		int ans = 0;
		for(int i=1;i<N+1;i++) {
			if(ans < dGo[i] + dBack[i]) {
				ans = dGo[i] + dBack[i];
			}			
		}
		System.out.println(ans);
	}
	private static void dijkstra(int X, ArrayList<ArrayList<Node8>> graph, int[] d) {
		PriorityQueue<Node8> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		d[X] = 0;
		pq.offer(new Node8(X,0));
		while(!pq.isEmpty()) {
			Node8 node = pq.poll();
			int dist = node.getDistance();	//�����Ÿ�
			int now = node.getIndex();	//���� ��ġ�� ���� �ε���
			//if(d[now] >= dist) {
			if(visit[now] == false) {
				visit[now] = true;
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();
					if(d[graph.get(now).get(i).getIndex()] > cost) {
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node8(graph.get(now).get(i).getIndex(),cost));
					}
				}
			}
		}
	}
}
