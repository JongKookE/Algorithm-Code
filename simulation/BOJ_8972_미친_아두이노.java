package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8972_미친_아두이노 {
	// 0���� 5�� ��ŵ�ؾߵ�
	static int[] dx = {-100, -1, 0, 1, -1 , -100, 1, -1, 0, 1}, dy = {-100, 1, 1, 1, 0, -100, 0, -1, -1, -1};
	static int count;
	static char[][] map;
	static char[] moveDir;
	static ArrayList<Robot> robots = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		map = new char[col][row];

		for (int i = 0; i < col; i++) {
			String s = br.readLine();
			for(int j = 0; j < row; j++) {
				map[i][j] = s.charAt(j);
				if(s.charAt(j) == 'I') robots.add(new Robot(i, j, true));
				else if(s.charAt(j) == 'R') robots.add(new Robot(i, j, false));
			}
		}
			
		moveDir = br.readLine().toCharArray();
		for(int i = 0; i < moveDir.length; i++) {
			count++;			
			jongsu(moveDir[i]);
			if(!isCrash()) {
				System.out.println("kraj " + count);
				return;
			}
//			for(char[] m : map) System.out.println(Arrays.toString(m));
//			System.out.println();
			
		}
		for(char[] chrs : map) {
			for(char ch : chrs) {
				System.out.print(ch);
			}
			System.out.println();
		}

	}
	// ��� �Ƶ��̳�� ���� �κ��� �����̴� ����
	static void jongsu(char move) {
		int y = 0, x = 0;
		// �� ������ ���� �ű� �Ŀ� �ؾߵ�
		for(int i = 0; i < robots.size(); i++) {	
			if(robots.get(i).isRobot) {				
				if(move != '5') {
					map[robots.get(i).y][robots.get(i).x] = '.';
					map[robots.get(i).y + dy[move - '0']][robots.get(i).x + dx[move - '0']] = 'I';
					robots.get(i).y += dy[move - '0'];
					robots.get(i).x += dx[move - '0'];				
				}				
				y = robots.get(i).y; 
				x = robots.get(i).x; 
			}
		}
				
			// ���� �Ƶ��̳���� �������� ��������� �ڵ带 ¥�߉�
			// �Ƶ��̳볢�� ��ġ�� �ڱ�鳢�� ������� �ڵ嵵 ¥�߉�
			// �׸��� �� �� �����Ű���
		for(int i = 0; i < robots.size(); i++) {
			if(!robots.get(i).isRobot) {					
				int min = Integer.MAX_VALUE, min_x = 0, min_y = 0;
				for(int d = 1; d <= 9; d++) {
					if (d == 5) continue;
					int nx = robots.get(i).x + dx[d];
					int ny = robots.get(i).y + dy[d];
					int myAbs = Math.abs(y - ny) + Math.abs(x - nx);
					if(myAbs < min) {
						min = myAbs;
						min_x = nx;
						min_y = ny;
					}					
				}
				map[robots.get(i).y][robots.get(i).x] = '.';
				map[min_y][min_x] = 'R';
				robots.get(i).y = min_y;
				robots.get(i).x = min_x;	
				}
			}		
		}		
	
	static boolean isCrash() {
		for(int i = 0; i < robots.size(); i++) {
			for(int d = i+1; d < robots.size(); d++) {	
				
				if(robots.get(i).x == robots.get(d).x && robots.get(i).y == robots.get(d).y) {
					if(robots.get(i).isRobot) return false;
					// �Ƶ��̳볢�� ��ġ��
					else {
						robots.remove(d);
						robots.remove(i);
						
					}
				}
			}
		}
		return true;
	}

	static class Robot {
		int y, x;
		// false ��� �Ƶ��̳�!
		boolean isRobot;

		public Robot(int y, int x, boolean isRobot) {
			super();
			this.y = y;
			this.x = x;
			this.isRobot = isRobot;
		}

	}

}
