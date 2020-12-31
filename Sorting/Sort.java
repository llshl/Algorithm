package Sorting;
import java.util.HashMap;
import java.util.HashSet;
public class Sort implements SortMethod{
	//�����Ʈ �ڱ� �ڽ� �ڿ� �ִ� ������ ���Ͽ� ������� swap ���� �ƴҰ�� continue
	//BigO�� �ּ� �־� ����� ��� ��� n^2�� ���� 
	//��� ���������� ���� ����
	//� ������ Ǯ�� �� ���Ĺ���� ����ϸ� �ð��ʰ�
	@Override
	public int[] BubbleSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=1; j<array.length; j++) {
				if(array[j]<array[j-1]) {
					int temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
		return array;
	}
	//�������ķ� �ѹ��� �ϳ��� ���� min���� ã�� ���ʷ� �����ϴ� ���
	//BigO�� n^2�־� �ּ� ��� ���
	//�״� ��õ�ϴ� ����� �ƴ� JAVA�� ��� Arrays.sort�Լ��� mergesort�� �̷���� ������
	//�ٸ� ����� ��� QuickSort Ȥ�� MergeSort�� �̷�� ���ִ°����� �˰�����
	@Override
	public int[] SelectionSort(int[] array) {
		int min=Integer.MAX_VALUE;
		int index=0;
		for(int i=0; i<array.length; i++) {
			for(int j=i; j<array.length; j++) {
				if(array[j]<min) {
					min=array[j];
					index=j;
				}
			}
			int temp=array[i];
			array[i]=array[index];
			array[index]=temp;
		} 
		return array;
	}
	//ó�� 0�� �ε����� ���ĵǾ��ٰ� �����ϰ� 1�� �ε������� 0���ε������� �����鼭 �װ����� ū�� �ٷ� �ڿ� �ִ¹��
	//�Ϲ� �������� �ٸ��� BigO�� �־� ��� �� n^2������ �ּ��ǰ�� n�̳��ü�����(������ �Ǿ��ְų� Ȥ�� �����͸� �����鼭 �����Ұ��)
	
	@Override
	public int[] InsertSort(int[] array) {
		int j=0;
		for(int i=1; i<array.length; i++) {
			int key=array[i];
			for(j=i-1; j>=0&&array[j]>key; j--) {
				array[j+1]=array[j];
			}
			array[j+1]=key;
			
		}
		return array;
	}

	@Override
	public int[] mergeSort(int[] array,int start, int end, int[] temp) {
		if(start<end) {
			int mid=(start+end)/2;
			mergeSort(array,start,mid,temp);
			mergeSort(array,mid+1,end,temp);
			
			int p=start;
			int q=mid+1;
			int index=p;
			while(p<=mid||q<=end) {
				if(q>end || (p<=mid && array[p]<array[q])) {
					temp[index++]=array[p++];
				}else {
					temp[index++]=array[q++];
				}
			}
			for(int i=start; i<=end; i++) {
				array[i]=temp[i];
			}
		}
		return array;
	}

	@Override
	public int[] QuickSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] ShellSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] RadixSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}
	//������ ���� ���� �ٸ�������� Map�� ����Ͽ� ���İ��� ���� �Ʒ� �ٸ��������� ���鿹��
	//�ߺ��� ��� �������Ŀ����ؼ� ������������ �������⵵�� �ſ� ���� ������ �� ����
	//Map �� ���� �������⵵ �ذ� ����
	@Override
	public int[] CounterSort(int[] array) {
		int max=0;
		for(int i=0; i<array.length; i++) {
			if(array[i]>max) {
				max=array[i];
			}
		}
		int[] tempArray=new int[max];
		for(int i=0; i<array.length; i++) {
			tempArray[array[i]-1]+=1;
		}
		int[] sortedArray=new int[array.length];
		int index=0;
		for(int i=0; i<tempArray.length; i++) {
			for(int j=0; j<tempArray[i]; j++) {
				sortedArray[index]=tempArray[i];
				index++;
			}
		}
		return sortedArray;
	}
	//Map�� Set�� ����Ͽ� �������⵵�� ���� ���̰�(������ ������ �ſ� Ŭ���) ������
	//�� BigO�� �־��� ��� n^2������ ��� BigO�� n�� ����
	
	@Override
	public int[] CounterSortMap(int[] array) {
		HashMap<Integer,Integer> map=new HashMap<>();
		HashSet<Integer> set=new HashSet<>();
		for(int i=0; i<array.length; i++) {
			if(map.containsKey(array[i])) {
				map.put(array[i],map.get(array[i])+1);
			}else {
				map.put(array[i],1);
				set.add(array[i]);
			}
		}
		int[] sortedArray=new int[array.length];
		int index=0;
		for(int i :set) {
			int num=map.get(i);
			for(int j=0; j<num; j++) {
				sortedArray[index]=i;
				index++;
			}
		}
		return sortedArray;
	}
	
	@Override
	public int[] HeapSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void printSortedArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		return;
	}
}
