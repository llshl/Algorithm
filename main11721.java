package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main11721 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0;i<s.length();i++) {
			System.out.print(s.charAt(i));
			if(i%10==9) {
				System.out.println("");
			}
		}
	}
}
