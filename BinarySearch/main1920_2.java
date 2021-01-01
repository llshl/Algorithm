package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main1920_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			int temp = binary(arr2[i],arr);
			System.out.println(temp);
		}
	}

	private static int binary(int n, int[] arr) {
		int first = 0;
		int last = arr.length-1;
		int mid = 0;
		while(first<=last) {
			mid = (first+last)/2;
			if(arr[mid] == n) {
				//Ž���ϴٰ� ã���� 1 ��ȯ
				return 1;
			}
			else {	//�� �� ������ �ٲ���
				if(arr[mid]<n) {
					first = mid+1;
				}
				else {
					last = mid - 1;
				}
			}
		}
		//Ž���Ϸ�ñ��� ��ã���� 0 ��ȯ
		return 0;
	}
}
