package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_사람_네트워크2_교수님 {
	static int[][] matrix;	
	static int T, N, min;
	static int BIG = 999999;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src\\input\\swea_1263_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(i != j && n == 0) matrix[i][j] = BIG;
					else matrix[i][j] = n;
				}
			}
			
			// 플로이드 워샬 알고리즘 적용 => matrix 변화 => matrix[i][j]: i -> j 최단
			
			for(int k = 0; k < N; k++) { // 경유지 고정한 상태에서 경유지를 제외한 i, j 에 의한 변화
				for(int i = 0; i < N; i++) {
					if (i == k) continue;
					for(int j = 0; j < N; j++) {
						if(j == i || j == k) continue;
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}
			min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					sum += matrix[i][j];
				}
				min = Math.min(sum, min);
			}
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
