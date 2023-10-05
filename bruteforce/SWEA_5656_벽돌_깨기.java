package bruteforce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌_깨기 {
	static int[][] bricks;
	static int ball, col, row, min;
	static int[] target, src;
	static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src//input//SWEA_5656_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ball = Integer.parseInt(st.nextToken());			
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			target = new int[ball];
			
			// 0 dummy
			bricks = new int[col+1][row+1];
			for(int i = 1; i <= col; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= row; j++) {
					bricks[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;			
			duplicatePerm(0);
			sb.append("#").append(t).append(" ").append(countBricks()).append("\n");
		}
		System.out.println(sb);

	}
	static void duplicatePerm(int cnt) {
		if(cnt == ball) {
			destroy();
			fallDown();
			System.out.println(123);
			return;
		}
		for(int i = 1; i <= row; i++) {
			target[cnt] = i;
			duplicatePerm(cnt + 1);
		}
	}
	
	static void destroy() {
		for(int t = 0; t < ball; t++) {
			int cnt = 1;
			for(int i = 1; i <= col; i++) {
				int ballNumber = bricks[i][target[t]];
				// 벽돌의 번호가 0이라면 비어있는 것
				if(ballNumber == 0) continue; 
				int y = i;
				int x = target[t];
				for(int d = 0; d < 4; d++) {
					int power = 0;
					while(power < ballNumber) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if(ny < 0 || nx < 0 || ny >= col || nx >= row) continue;
						bricks[ny][nx] = 0;
						power++;
					}
				}
			}				
		}		
	}
	
	static void fallDown() {
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i = 1; i <= col; i++){
			for(int j = 1; j <= row; j++)  if(bricks[i][j] != 0) stack.add(bricks[i][j]);
			for(int j = col; j >= 1; j--){
				if(stack.isEmpty()) bricks[j][i] = 0;
				else bricks[j][i] = stack.pollLast();
			}
		}
	}

	static int countBricks(){
		int count = 0;
		for(int i = 1; i <= col; i++){
			for(int j = 1; j <= row; j++){
				if(bricks[i][j] != 0) count++;
			}
		}
		return count;
	}

}
