package String;

import java.util.Scanner;

public class main1157 {

	public static void main(String[] args) {
		int[] alpha = new int[26];
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String up = s.toUpperCase();
		for(int i=0;i<26;i++) {
			for(int j=0;j<up.length();j++) {
				if((65+i) == (int)up.charAt(j)) {
					alpha[i]++;
				}
			}
		}

		//���� ���� ī��Ʈ �� �ε��� ã��
		int big = 0;
		int temp;
		int ansIndex=-1;
		boolean equalFlag = false;	//false�϶� ���� ī��Ʈ�� ����
		for(int i=0;i<26;i++) {
			if(big<alpha[i]) {
				big = alpha[i];
				ansIndex = i;
				equalFlag = false;
			}
			else if(big == alpha[i]) {
				equalFlag = true;
			}
		}
		if(equalFlag == true) {
			System.out.println("?");
		}
		else {
			System.out.println((char)(65+ansIndex));
		}
	}
}
