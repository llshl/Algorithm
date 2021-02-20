package Greedy;

import java.util.Arrays;

class Boat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        for(int i=people.length-1;i>-1;i--) {
        	if(people[i] + people[start] > limit) {	//�Ǿ� �ǵ��߿� �Ѹ� Ż���ִٸ�
        		answer++;	//�ǵڸ� ������(�ǵڴ� i�� ����Ű�Ƿ� �ڵ����� �Ѿ)
        	}
        	else {		//�Ѵ� Ż���ִٸ�
        		start++;	//�Ǿհ� �ǵ� �Ѵ� ������(�ǵڴ� i�� ����Ű�Ƿ� �ڵ����� �Ѿ�� �� ���� start++����)
        		answer++;
        	}
        }
        return answer;
    }
}
//50 50 70 80
public class ����Ʈ {

	public static void main(String[] args) {
		Boat b = new Boat();
		int[] people = {40,50,60,90};
		int limit = 100;
		int answer = b.solution(people, limit);
		System.out.println(answer);

	}

}
