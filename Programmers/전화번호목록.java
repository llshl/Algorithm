package All;

class haesihaesi {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0;i<phone_book.length;i++) {
        	int len = phone_book[i].length();
        	for(int j=i+1;j<phone_book.length;j++) {
        		//�񱳱��� ���̺��� �񱳴�� ���̰� �� ū��� && �񱳱��� �ؽð��� �񱳴�� �ؽð�(�񱳱��ذ� �������̱�����)�� �������
        		//ex) 119�� 1193424
        		if(len <= phone_book[j].length() && phone_book[i].hashCode() == phone_book[j].subSequence(0, len).hashCode()) {
        			return false;
        		}
        		//�� ����� �� ū���
        		//11925�� 119
        		if(len > phone_book[j].length() && phone_book[i].substring(0,phone_book[j].length()).hashCode() == phone_book[j].hashCode()) {
        			return false;
        		}
        	}
        }
        return answer;
    }
}

public class ��ȭ��ȣ��� {

	public static void main(String[] args) {
		haesihaesi s = new haesihaesi();
		String[] phone = {"119","976764223","16195524421"};
		System.out.println(s.solution(phone));

	}

}
