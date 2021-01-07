package JksHomeWork;

//O(n^2)
public class SelectionSort {
	public static int[] arr = {9,0,6,7,5,-50,3,11,1,4,8,15,-1,-34,5,-34,-2,0};
	public static int minindex;
	public static boolean flag = false; 
	public static void main(String[] args) {
		Show(arr);
		System.out.println("====================���Ľ���====================");
//����========================================================================
		int min;
		minindex = -1;
		for(int i=0;i<arr.length;i++) {
			min = arr[i];
			for(int j=i+1;j<arr.length;j++) {
				if(min>arr[j]) {
					min = arr[j];
					minindex = j;	//���� min���� �� ���� �� ã���� �� �ε��� ����
					flag = true;	//min���� ���� ���� ���� ã������ true
				}
			}
			if(flag == true) {	//���� ���ŵ� �ּҰ��� ������ swap
				swap(i,minindex);
				flag = false;
			}
		}
//����========================================================================
		System.out.println("====================���ĿϷ�====================");
		Show(arr);

	}
	private static void swap(int i, int minindex) {
		int temp = arr[i];
		arr[i] = arr[minindex];
		arr[minindex] = temp;
		Show(arr);
	}
	
	//��ü�� �Ͼ���� ���
	public static void Show(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
}
