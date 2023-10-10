package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지_안녕 {
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int R,C,T;
	static int[][] map;
	static boolean[] visited;
	static ArrayList<int[]> dust = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		// 공기청정기의 위치
		int locX1 = 0;
		int locY1 = 0;
		int locX2 = 0;
		int locY2 = 0;
		
		map = new int[R][C];
		for(int r = 0; r < R; r++){
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < R; c++) {				
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] != -1 && map[r][c] != 0) dust.add(new int[] {r, c});
				if(map[r][c] == -1) {
					locX1 = r-1;
					locY1 = c;
					locX2 = r;
					locY2 = c;
				}
			}
		}		
		
		for(int i = 0; i < T; i++) {
			// 미세먼지 확산
			// for(int d = 0; d < dust.size(); d++) spread(dust.get(d)[0], dust.get(d)[1]);
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(map[r][c] != -1 && map[r][c] != 0) spread(r,c);
				}
			}
			
			
		}
		
	}
	static void printMap() {
		for(int i = 0; i < R; i++) System.out.println(Arrays.toString(map[i]));
		System.out.println();
	}
	// R = y, C = x
	static void clean1(int locY, int locX) {
		goRight(locY, locX);
		goUp(locY, C);
		goLeft(0, C);
		goDown(R, locX);
	}
	
	static void clean2(int locY, int locX) {
		goRight(locY, locX);
		goDown(locY, C);
		goLeft(0, C);
		goUp(R, locX);		
	}
	
	// R = y, C = x
	static void goRight(int r, int c) {
		for(int i = c; i < C; i++) map[r][i] = 0;
	}
	static void goUp(int r, int c) {
		for(int i = r; i > 0; i--) map[i][c] = 0;
	}
	static void goLeft(int r, int c) {
		for(int i = c; i > 0; i--) map[r][i] = 0;
	}
	static void goDown(int r, int c) {
		for(int i = r; i < R; i++ ) map[i][c] = 0;
	}
	
	// r = y, c = x
	static void spread(int r, int c) {
		int count = 1;
		ArrayList<int[]> lst = new ArrayList<>();
		for(int d = 0; d < 4; d++) {
			int ny = c + dy[d];
			int nx = r + dx[d];
			System.out.println(ny + " " + nx);
			if(!check(ny, nx)) continue;
			lst.add(new int[] {ny, nx});
			count++;
			System.out.println("many");
		}
		
		for(int i = 0; i < lst.size(); i++) {
			int y = lst.get(i)[0];
			int x = lst.get(i)[1];
			map[y][x] += map[r][c]/count;
		}	
		
		map[r][c] = map[r][c]/count + map[r][c] % count;		
		
	}
	
	static boolean check(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C || map[r][c] == -1) return false;
		return true;
	}
}
