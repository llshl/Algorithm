package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

class Truck{
	private int time;
	private int weight;
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Truck(int time, int weight) {
		super();
		this.time = time;
		this.weight = weight;
	}
	
}

class Solution2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> q = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++) {
        	q.add(new Truck(0,truck_weights[i])); 	//time�̶� bridge_length�� ������ �ٸ������
        }
        int totalWeight = 0;
        
       	while(!q.isEmpty()) {
       		if(!bridge.isEmpty() && bridge.peek().getTime() == bridge_length) {	//������ Ʈ���� �ٸ��� �� �ǳԴٸ�
	       		Truck truck = bridge.poll();									//�ٸ����� Ʈ�� poll
	       		totalWeight -= truck.getWeight();								//���� Ʈ���� ���Ը�ŭ ���� ���� ����
	       	}
	       	if(totalWeight + q.peek().getWeight() <= weight) {					//���԰� �����־ �ٸ��� �� �����Ҽ��ִٸ�
	       		Truck truck = q.poll();											//���ť(q)���� �ϳ����� �ٸ�ť�� ����
	       		totalWeight += truck.getWeight();
	       		bridge.add(truck);	//�ٸ� ����
	       	}
	       	for(int i=0;i<bridge.size();i++) {		//�ٸ������ִ� ��� Ʈ���� �Ÿ��� 1�� �ø���
	       		Truck truck = bridge.poll();		//poll�ؼ� �� ���� �� �ٽ� add(�տ��� ���� �ڷ� �ٽ� �ֱ�)
	       		truck.setTime(truck.getTime()+1);
	       		bridge.add(truck);
	       	}
	       answer++;
        }
       	//q�� ��¼��� Ż���ϱ⿡ ���������� �ٸ��� ������ ���� ���������µ� �ɸ��� �ð��� bridge_length�� ����
        return answer+bridge_length;
    }
}

public class �ٸ���������Ʈ�� {

	//+1����� �ٸ����� ������������
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7,4,5,6};
		int bridge_length = 5;
		int weight = 5;
		int[] truck_weights = {2,2,2,2,1,1,1,1,1};
		int answer = -1;
		answer = solution.solution(bridge_length,weight,truck_weights);
		System.out.println(answer);
	}

}
