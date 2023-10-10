package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_4013_특이한_자석 {
	static int T, K;
	static ArrayList<ArrayList<Integer>> magnets;
	static ArrayList<ArrayList<Integer>> tempMagnets;
	Deque<Integer> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src//input//SWEA_4013_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			
			magnets = new ArrayList<>();
			tempMagnets = new ArrayList<>();
			
			for(int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				magnets.add(new ArrayList<>());
				tempMagnets.add(new ArrayList<>());
				
				for(int j = 0; j < 8; j++) {
					int temp = Integer.parseInt(st.nextToken());
					magnets.get(i).add(temp);
					tempMagnets.get(i).add(temp);
				}
			}
			
			// 3번째 값과 7번째 값이 서로 다르다면 Turn
			// 0이 N극 1이 S극
			
			printMap();
			System.out.println();
			for(int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int magnetIndex= Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				turn(magnetIndex, direction);
				printMap();
			}
			int res = 0;
			for(int i = 0; i < 4; i++) {
				int temp = magnets.get(i).get(0);
				if(temp == 1) {
					res += Math.pow(2, i);
				}
				
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
		
	}
	// 1이 시계방향 -1이 반시계방향
	static void turn(int idx, int dir) {
		if(idx == 1) {
			if(magnets.get(0).get(2) != magnets.get(1).get(6)) {
				circle(0, dir);
				circle(1, -dir);
				if(magnets.get(1).get(2) != magnets.get(2).get(6)) {
//					circle(1, dir);
					circle(2, dir);
					if(magnets.get(2).get(2) != magnets.get(3).get(6)) {
//						circle(2, dir);
						circle(3, -dir);
					}
				}				
			}
		}
		else if (idx == 2) {
			boolean valid = false;
			if(magnets.get(1).get(6) != magnets.get(0).get(2)) {
				valid = true;
				circle(1, dir);
				circle(0, -dir);
			}
			if(magnets.get(1).get(2) != magnets.get(2).get(6)) {
				if (!valid) circle(1, dir);				
				circle(2, -dir);
				if(magnets.get(2).get(2) != magnets.get(3).get(6)) {
//					circle(2, dir);
					circle(3, dir);
				}
			}							
		}
		
		else if (idx == 3) {
			boolean valid = false;
			if(magnets.get(2).get(2) != magnets.get(3).get(6)) {
				valid = true;
				circle(2, dir);
				circle(3, -dir);
			}
			if(magnets.get(2).get(6) != magnets.get(1).get(2)) {
				if(!valid) circle(2, dir);
				circle(1, -dir);
				if(magnets.get(1).get(6) != magnets.get(0).get(2)) {
//					circle(1, dir);
					circle(0, dir);
				}
			}				
			
		}
		else if (idx == 4) {
			if(magnets.get(3).get(6) != magnets.get(2).get(2)) {
				circle(3, dir);
				circle(2, -dir);
				if(magnets.get(2).get(6) != magnets.get(1).get(2)) {
//					circle(2, dir);
					circle(1, dir);
					if(magnets.get(1).get(6) != magnets.get(0).get(2)) {
//						circle(1, dir);
						circle(0, -dir);
					}
				}				
			}
		}
		magnets = tempMagnets;
		
	}
	
	static void circle(int idx, int dir) {
		if(dir == 1) {
			int temp = magnets.get(idx).get(7);
			tempMagnets.get(idx).remove(7);
			tempMagnets.get(idx).add(0, temp);
		}
		else {
			int temp = magnets.get(idx).get(0);
			tempMagnets.get(idx).remove(0);
			tempMagnets.get(idx).add(7, temp);
		}	
	}
	
	static void printMap() {
		for(int i = 0; i < 4; i++) {
			System.out.println(magnets.get(i));
		}
	}
}
