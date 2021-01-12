package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Node16{
	private int x;
	private int y;
	private int move;
	
	public Node16(int x, int y, int move) {
		this.x = x;
		this.y = y;
		this.move = move;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	
}

public class main13460 {
	public static int N;
	public static int M;
	public static int ans;
	public static boolean flag = false;	//�������� ���ٸ� true
	public static boolean BlueTurn = false;
	public static char[][] arr;
	public static Queue<Node16> qRed;
	public static Queue<Node16> qBlue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		qRed = new LinkedList<>();
		qBlue = new LinkedList<>();
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		arr = new char[N][M];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = input.charAt(j);
				if(arr[i][j] == 'R') {
					qRed.add(new Node16(i,j,1));
				}
				if(arr[i][j] == 'B') {
					qBlue.add(new Node16(i,j,1));
				}
			}
		}
		
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		while(!qRed.isEmpty()) {	//�������� �����̴�.
			Node16 Red = qRed.poll();
			Node16 Blue = qBlue.poll();
			int xred = Red.getX();
			int yred = Red.getY();
			int xblue = Blue.getX();
			int yblue = Blue.getY();
			int movered = Red.getMove();
			int moveblue = Blue.getMove();
			if(movered == 11) {	//10���� ������
				//-1����ϸ� ����
				ans = -1;
				return;
			}//��ĭ���ۿ� �ȿ����δ�
			//move�� �������ڸ��� 1 �÷�����Ѵ�
			arr[xred][yred] = '.';
			arr[xblue][yblue] = '.';
			for(int i=0;i<4;i++) {	//arr���� �������� R B��ġ��
				
				//�Ķ��� ���� �����̰� �� �ڷ� ������ �����̴� ��쵵 �����ؾ��Ѵ�
				int nxred = -1;
				int nyred = -1;	
				int nxblue = -1;
				int nyblue = -1; 
				if(i == 0) {
					if(xred<xblue) {	//���ΰ����϶� ������ �� �����ִٸ� �������� ����
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//������ ���ٸ� , //������ �� �� ���ÿ� �Ķ��� ���� �ȵȴ�.
							flag = true;		//�߰��� ���ٴ� ǥ���̰� �ٷ� �ڿ� �Ķ��� �ȵ��ٸ� for�� �������� true�� ���´�
						}else {
							arr[nxred][nyred] = 'R';
						}
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//�Ķ����� ��ư���� ��ŵ
						}
						arr[nxblue][nyblue] = 'B';	
					}
					else {	//�Ķ��� �� ���������� �Ķ����� ����
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//�Ķ����� ��ư���� ��ŵ
						}
						arr[nxblue][nyblue] = 'B';	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//������ ���ٸ� , //������ �� �� ���ÿ� �Ķ��� ���� �ȵȴ�.
							flag = true;		//�߰��� ���ٴ� ǥ���̰� �ٷ� �ڿ� �Ķ��� �ȵ��ٸ� for�� �������� true�� ���´�
						}else {
							arr[nxred][nyred] = 'R';
						}
					}
				}
				else if(i==1) {
					if(xred<xblue) {	//�Ʒ��ΰ����϶� �Ķ��� �� ���������� �Ķ����� ����
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//�Ķ����� ��ư���� ��ŵ
						}
						arr[nxblue][nyblue] = 'B';	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);
						if(nxred == 500 || nyred == 500) {	//������ ���ٸ� , //������ �� �� ���ÿ� �Ķ��� ���� �ȵȴ�.
							flag = true;		//�߰��� ���ٴ� ǥ���̰� �ٷ� �ڿ� �Ķ��� �ȵ��ٸ� for�� �������� true�� ���´�
						}else {
							arr[nxred][nyred] = 'R';
						}
					}
					else {	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//������ ���ٸ� , //������ �� �� ���ÿ� �Ķ��� ���� �ȵȴ�.
							flag = true;		//�߰��� ���ٴ� ǥ���̰� �ٷ� �ڿ� �Ķ��� �ȵ��ٸ� for�� �������� true�� ���´�
						}else {
							arr[nxred][nyred] = 'R';
						}
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//�Ķ����� ��ư���� ��ŵ
						}
						arr[nxblue][nyblue] = 'B';	
					}
				}
				else if(i==2) {
					if(yred<yblue) {	//���ʰ����϶� ������ �� ���ʿ������� �������� ����
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//������ ���ٸ� , //������ �� �� ���ÿ� �Ķ��� ���� �ȵȴ�.
							flag = true;		//�߰��� ���ٴ� ǥ���̰� �ٷ� �ڿ� �Ķ��� �ȵ��ٸ� for�� �������� true�� ���´�
						}else {
							arr[nxred][nyred] = 'R';
						}
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//�Ķ����� ��ư���� ��ŵ
						}
						arr[nxblue][nyblue] = 'B';	
					}
					else {
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//�Ķ����� ��ư���� ��ŵ
						}
						arr[nxblue][nyblue] = 'B';	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);
						if(nxred == 500 || nyred == 500) {	//������ ���ٸ� , //������ �� �� ���ÿ� �Ķ��� ���� �ȵȴ�.
							flag = true;		//�߰��� ���ٴ� ǥ���̰� �ٷ� �ڿ� �Ķ��� �ȵ��ٸ� for�� �������� true�� ���´�
						}else {
							arr[nxred][nyred] = 'R';
						}
					}
				}
				else if(i==3) {
					if(yred<yblue) {	//���������� �����϶� �Ķ��� �� �����ʿ������� �Ķ����� ����
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//�Ķ����� ��ư���� ��ŵ
						}
						arr[nxblue][nyblue] = 'B';	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);
						if(nxred == 500 || nyred == 500) {	//������ ���ٸ� , //������ �� �� ���ÿ� �Ķ��� ���� �ȵȴ�.
							flag = true;		//�߰��� ���ٴ� ǥ���̰� �ٷ� �ڿ� �Ķ��� �ȵ��ٸ� for�� �������� true�� ���´�
						}else {
							arr[nxred][nyred] = 'R';
						}
					}
					else {	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//������ ���ٸ� , //������ �� �� ���ÿ� �Ķ��� ���� �ȵȴ�.
							flag = true;		//�߰��� ���ٴ� ǥ���̰� �ٷ� �ڿ� �Ķ��� �ȵ��ٸ� for�� �������� true�� ���´�
						}else {
							arr[nxred][nyred] = 'R';
						}
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//�Ķ����� ��ư���� ��ŵ
						}
						arr[nxblue][nyblue] = 'B';	
					}
				}
				
				qRed.add(new Node16(nxred,nyred,movered+1));
				qBlue.add(new Node16(nxblue,nyblue,moveblue+1));
				arr[nxred][nyred] = '.';
				arr[nxblue][nyblue] = '.';
				if(flag == true) {
					ans = movered;
					return;
				}
			}
		}
		
	}
	private static int gotoEndY(int x, int y, int dir) {	//x��ǥ�� �����¿� ����
		if(dir == 0) {	//�� �� �̵��̸� y��ǥ�� �״�� ��ȯ
			return y;
		}
		else if(dir == 1) {
			return y;
		}
		else if(dir == 2) {
			while(true) {
				if(arr[x][y-1] == '.') {
					y = y-1;
				}
				else if(arr[x][y-1] == 'O') {
					//������ �����Ƿ� ó������
					y = 500;
					break;
				}
				else {
					break;
				}
			}
			return y;
		}
		else {
			while(true) {
				if(arr[x][y+1] == '.') {
					y = y+1;
				}
				else if(arr[x][y+1] == 'O') {
					y = 500;
					break;
				}
				else {
					break;
				}
			}
			return y;
		}
	}
	
	private static int gotoEndX(int x, int y, int dir) {
		if(dir == 0) {
			while(true) {
				if(arr[x-1][y] == '.') {
					x = x-1;
				}
				else if(arr[x-1][y] == 'O') {
					x = 500;
					break;
				}
				else {
					break;
				}
			}
			return x;
		}
		else if(dir == 1) {
			while(true) {
				if(arr[x+1][y] == '.') {
					x = x+1;
				}
				else if(arr[x+1][y] == 'O') {
					x = 500;
					break;
				}
				else {
					break;
				}
			}
			return x;
		}
		else if(dir == 3) {	//�� �� �̵��̸� x��ǥ�� �״�� ��ȯ
			return x;
		}
		else{
			return x;
		}
	}
}
