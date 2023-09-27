package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_사람_네트워크2 {
	static int[][] graph;
	static int[][] infinity;
	static int[] result;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src\\input\\test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int row = Integer.parseInt(st.nextToken());
			graph = new int[row][row];
			infinity = new int[row][row];
			result = new int[row];
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < row; i++) Arrays.fill(infinity[i], INF);
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < row; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < row; j++) {
					System.out.print(graph[i][j] + " ");
				}
				System.out.println();
			}
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < row; j++) {
					for(int k = 0; k < row; k++) {
						
					}
				}
				
			}
			
			
			sb.append("#").append(t).append(" ").append(result[min]);
		}
	}

}
