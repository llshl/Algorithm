package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class main4949 {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Stack<Character> st = new Stack<Character>();
//		boolean flag = true;	//false��� �߸��� ����
//
//		while(true){
//			st.clear();
//			String s = br.readLine();
//			
//			for(int i=0;i<s.length();i++) {
//				if(s.charAt(i)=='.'){
//					break;
//				}
//				if(s.charAt(i) == '[' || s.charAt(i) == '(') {
//					//���� ��ȣ�� ���ÿ� ����
//					st.push(s.charAt(i));
//				}
//				else if(s.charAt(i) == ']' || s.charAt(i) == ')') {	//�ݴ°�ȣ���
//					if(st.isEmpty()) {	//�ƹ��͵� ���µ� �ݴ°�ȣ���� ���� ��
//						System.out.println("no");
//						flag = false;	
//						break;
//					}
//					char temp = st.peek();	//���� ������ ��
//					if((temp == '(' && s.charAt(i) == ')') || (temp == '[' && s.charAt(i) == ']')) {
//						st.pop();
//					}
//					else {
//						System.out.println("no");
//						flag = false;
//						break;
//					}
//				}
//			}
//			if(st.isEmpty() && flag == true) {
//				System.out.println("yes");
//			}
//		}
		String s = "abcbe";
		char c = s.charAt(1);
		s = s.replace(Character.toString(c),"");
		System.out.println(s);
	}

}
