package All;

import java.util.HashMap;

class M {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String s : participant) {
        	if(hm.get(s) == null) {	//�ߺ�X���
        		hm.put(s, hm.getOrDefault(s, 0)+1);	//s��� key�� ������ �� Ű��ȯ�� +1, ������ 0��ȯ �� +1
        	}
        }
        for(String s : completion) {
        	hm.put(s, hm.get(s)-1);	//�ش� Ű�� s�� value�� -1�ؼ� �ٽó���
        }
        for(String s : hm.keySet()) {
        	if(hm.get(s) != 0) {		//������ 1�� ���ֱ⸦ �ݺ������� �� 0�̾����
        		return s;	
        	}
        }
        return null;
    }
}

/*
 * String answer = ""; Arrays.sort(participant); Arrays.sort(completion); int
 * index = -1; for(int i=0;i<participant.length;i++) { try {
 * if(!participant[i].equals(completion[i])) { index = i; break; }
 * }catch(Exception e) { index = participant.length-1; } } return
 * participant[index];
 */
public class �����������Ѽ��� {

	public static void main(String[] args) {
		M s = new M();
		String[] p = {"marina","josipa","marina","vinko"};
		String[] c = {"josipa","marina","marina"};
		String answer = s.solution(p, c);
		System.out.println(answer);
	}

}
