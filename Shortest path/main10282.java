package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node15 implements Comparable<Node15>{
	private int index;
	private int distance;
	
	public Node15(int index, int distance) {
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
	public int compareTo(Node15 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
	
}

public class main10282 {

	public static int T,n,d,c;
	public static int lastCom = -1;
	public static int[] di;
	public static ArrayList<ArrayList<Node15>> graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {	//�׽�Ʈ ���̽��� �����Ƿ� ������������ ��� ���� �����ؾ��Ѵ�. ���� 
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			di = new int[n+1];
			graph = new ArrayList<ArrayList<Node15>>();
			for(int i=0;i<=n;i++) {
				graph.add(new ArrayList<Node15>());
			}
			
			for(int i=0;i<d;i++) {	//��������
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				graph.get(b).add(new Node15(a,c));
			}
			Arrays.fill(di, Integer.MAX_VALUE);
			dijkstra(c,graph);
			int countCom = 0;
			//INF�� �ƴ� di�ε��� ������ ���� �װ� ������ ���� ����
			for(int i=1;i<di.length;i++) {
				if(di[i] != Integer.MAX_VALUE) {
					countCom++;
				}
			}
			//INF�� ������ ���� ���� ū ���� ���������Ͱ� �����Ǵµ� �ɸ��� �ð�
			int max = -1;
			for(int i=1;i<di.length;i++) {
				if(di[i] != Integer.MAX_VALUE) {
					if(max < di[i]) {
						max = di[i];
					}
				}
			}
			sb.append(countCom+" "+max+"\n");
		}
		System.out.println(sb);
		sb.setLength(0);
	}
	private static void dijkstra(int start, ArrayList<ArrayList<Node15>> graph) {
		PriorityQueue<Node15> pq = new PriorityQueue<Node15>();
		boolean[] visit = new boolean[n+1];
		di[start] = 0;
		pq.offer(new Node15(start,0)); 
		while(!pq.isEmpty()) {
			Node15 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			if(visit[now] == false) {
				visit[now] = true;
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();
					if(di[graph.get(now).get(i).getIndex()] > cost) {
						di[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node15(graph.get(now).get(i).getIndex(),cost)); 
					}
				}
			}
		}
	}
}
