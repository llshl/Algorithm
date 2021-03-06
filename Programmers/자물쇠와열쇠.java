package All;

class Keyy {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int len = key.length;
        int[][] expandedLock = createExpandedLock(len,lock);
 
        for(int t=0;t<4;t++) {
        	key = rotateKey(key);
	        for(int x=0;x<=expandedLock.length-len;x++) {
	        	for(int y=0;y<=expandedLock.length-len;y++) {
	        		
	        		for(int i=0;i<len;i++) {
	        			for(int j=0;j<len;j++) {
	        				expandedLock[x+i][y+j] += key[i][j];
	        			}
	        		}
	        		if(isOpen(expandedLock,x,y,len,lock)) {
	        			answer = true;
	        			return answer;
	        		}
	        		for(int i=0;i<len;i++) {
	        			for(int j=0;j<len;j++) {
	        				expandedLock[i+x][j+y] -= key[i][j];
	        			}
	        		}
	        	}
	        }
        }
        return answer;
    }

	private boolean isOpen(int[][] expandedLock, int x, int y, int len, int[][] lock) { 	//Ȯ��� �ڹ��� �迭���� keyũ�⸸ŭ�� �� 1���� Ȯ���ϴ°�
		boolean flag = true; 
		int lockLen = lock.length;
		for(int i=0;i<lockLen;i++) {	//x���� key�� ũ�⸸ŭ
			for(int j=0;j<lockLen;j++) {
				if(expandedLock[i+len-1][j+len-1] == 0) {	//�ѹ��̶� 0 ������ false�� 
					flag = false;
					break;
				}
				if(expandedLock[i+lockLen-1][j+lockLen-1] == 2) {	//�ѹ��̶� 2 ������ false��
					flag = false;
					break;
				}
			}
			if(flag == false) {
				break;
			}
		}
		return flag;
	}

	private int[][] createExpandedLock(int len, int[][] lock) {
		int expandSize = len*2+lock.length-2;
		int[][] returnArr = new int[expandSize][expandSize];
		for(int i=0;i<lock.length;i++) {
			for(int j=0;j<lock.length;j++) {
				returnArr[i+len-1][j+len-1] = lock[i][j]; 
			}
		}
		return returnArr;
	}

	private int[][] rotateKey(int[][] key) {
		int[][] rotated = new int[key.length][key[0].length];
		 for(int i=0;i<key.length;i++) {
			 for(int j=0;j<key[i].length;j++) {
				 rotated[i][j] = key[j][key.length-1-i];
			 }
		 }
		return rotated;
	}
	public void show(int[][] expandedLock, int len, int[][] lock) {
		for(int i=len-1;i<len-1+lock.length;i++) {
			for(int j=len-1;j<len-1+lock.length;j++) {
				System.out.print(expandedLock[i][j]);
			}
			System.out.println("");
		}
	}
}

public class �ڹ���Ϳ��� {

	public static void main(String[] args) {
		Keyy s = new Keyy();
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(s.solution(key, lock));
	}

}
