package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class main2110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] home = new int[N];
		int C = sc.nextInt();
		for(int i=0;i<N;i++) {
			home[i] = sc.nextInt();
		}
		Arrays.sort(home);
		int first = 0;
		int last = home[home.length-1] - home[0];
		int d = 0;	//d�������� ������ C�� ��ġ
		int ans = 0;
		while(first<=last) {
			int mid = (first+last)/2;
			int start = home[0];
			int cnt=1;	//������ ����
			for(int i=0;i<N;i++) {
				d = home[i]-start;
				if(mid <= d) {
					cnt++;
					start = home[i];
				}
			}
			if(cnt>=C) {
				ans = mid;
				first = mid+1;
			}
			else {
				last = mid-1;
			}
		}
		System.out.println(ans);
	}
}
