package String;

public class �űԾ��̵���õ {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(new_id));
		
	}
	public static String solution(String new_id) {
		String lowerId = new_id.toLowerCase();		//��� �ҹ��ڷ�
		
		StringBuilder st = new StringBuilder();
		for(int i=0;i<lowerId.length();i++) {
			char temp = lowerId.charAt(i);
			if((48<=temp && temp<=57) || (97<=temp && temp<=122) || temp=='-' || temp=='_' || temp==46) {//���ڸ�, ����, ����, ��ħǥ
				st.append(temp);
			}
		}
		String Id = st.toString();	//2�ܰ���� �Ϸ�
		StringBuilder sb = new StringBuilder();
		
		boolean flag = false;
		for(int i=0;i<Id.length();i++) {
			if(Id.charAt(i)=='.' && flag==false) {
				sb.append(Id.charAt(i));
				flag = true;
			}else if(Id.charAt(i) != '.'){
				sb.append(Id.charAt(i));
				flag = false;
			}
		}	//3�ܰ� �Ϸ�===> ��ħǥ�� �ΰ� �̻��ΰŴ� �� �Ѱ��� ġȯ�ؾ��Ѵ�
		
		
		Id = sb.toString();
		
		if(Id.charAt(0) == '.') {
			if(Id.length() == 1) {	//�� ���� ���ڿ��� . �Ѱ��ϰ����
				Id = "";
			}
			else{
				Id = Id.substring(1);
			}
		}
		if(Id.length() > 0 && Id.charAt(Id.length()-1) == '.') {	//���ڿ��� ""�� ��쿣 �ε��������� ���
			Id = Id.substring(0, Id.length()-1);		//4�ܰ�Ϸ�
		}
		
		if(Id.equals("")) {
			Id += "a";
		}	//5�ܰ�Ϸ�
		
		if(Id.length() >= 16) {
			Id = Id.substring(0, 15);
			if(Id.charAt(Id.length()-1) == '.') {
				Id = Id.substring(0, 14);
			}
		}//6�ܰ� �Ϸ�
		
		if(Id.length() <= 2) {
			while(!(Id.length()==3)) {
				Id += Id.charAt(Id.length()-1);
			}
		}
		
        String answer = Id;
        return answer;
    }

}
