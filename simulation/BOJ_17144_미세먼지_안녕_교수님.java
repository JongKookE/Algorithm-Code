package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지_안녕_교수님 {
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int R,C,T;
	static int[][] map, tempMap;
	static int[][] cPos = new int[2][2];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		tempMap = new int[R][C];
		
		int cIdx = 0;
		for(int r = 0; r < R; r++){
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < R; c++) {				
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					cPos[cIdx][0] = r;
					cPos[cIdx][1] = c;
				}
			}
		}	
		
		for(int i = 0; i < T; i++) {
			// 확산
			spread();
			// 청정
			clear();
		}
		
		int ans = 0;
		for(int r = 0; r < R; r++) for(int c = 0; c < C; c++) ans += map[r][c]; 					
		
		System.out.println(ans+2);
	}
	
	static void spread() {
		// tempMap 초기화
		// tempMap 에 풀이를 적용해간다.
		// tempMap => map으로 원복
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				tempMap[r][c] = 0; 			
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				tempMap[r][c] += map[r][c]; // 이전 좌표에서 현 좌표에 의미있는 값이 생겼을 수도 있기 때문  	
				
				if(map[r][c] < 5) continue;
				int spreadCnt = map[r][c] / 5;
				
				for(int d = 0; d < 4; d++) {
					int ny = c + dy[d];
					int nx = r + dx[d];
					if(r < 0 || c < 0 || r >= R || c >= C || map[r][c] == -1) continue;
					tempMap[r][c] -= spreadCnt;
					tempMap[ny][nx] += spreadCnt;
				}
				
			}
		}
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				map[r][c] = tempMap[r][c];		
			}
		}
		
	}
	
	static void clear() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				tempMap[r][c] = 0; 			
			}
		}
		
		for(int i = 0; i < 2; i++) {
			int ny = cPos[i][0];
			int nx = cPos[i][1] + 1;
			while(nx < C - 1) {
				tempMap[ny][nx+1] = map[ny][nx];
				nx++;
			}
			
			// 위, 또는 아래
			if(i == 0) { // 위 쪽 청정기
				while(ny > 0) {
					tempMap[ny-1][nx] = map[ny][nx];
					ny--;
				}
			}
			else {
				while(ny < R - 1) {
					tempMap[ny+1][nx] = map[ny][nx];
					ny++;
				}
			}
			
			while(nx > 0) {
				tempMap[ny][nx-1] = map[ny][nx];
				nx++;
			}
			
			// 위, 또는 아래
			if(i == 0) { // 위 쪽 청정기
				while(ny < cPos[i][0] - 1) {
					tempMap[ny-1][nx] = map[ny][nx];
					ny++;
				}
			}
			
			
			else {
				while(ny > cPos[i][1] + 1) {
					tempMap[ny+1][nx] = map[ny][nx];
					ny--;
				}
			}			
		}
		
		// tempMap 변경 분 map 에 반영
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(r == 0 || r == R - 1 || c == 0 || c == C-1 || r == cPos[0][0] || c == cPos[1][0]) 
					map[r][c] = tempMap[r][c];		
			}
		}
	}
}
