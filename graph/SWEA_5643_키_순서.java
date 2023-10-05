package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키_순서 {
	static int T, vertex, edge, isBig, isSmall;
	static int[][] lst;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src//input//SWEA_5643_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			vertex = Integer.parseInt(br.readLine());
			edge = Integer.parseInt(br.readLine());
			lst = new int[vertex + 1][vertex + 1];

			for(int e = 1; e <= edge; e++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				lst[a][b] = 1;
			}
//			for(int i = 1; i <= edge; i++) chain(i);
		}
	}
	
	// 단방향 그래프니까 내가 가르킨 방향은 무조건 나보다 큼
	// 그 반대로 가르킨값은 나보다 무조건 작음
	static void big(int start, boolean[] visited) {
		visited[start] = true;
		for(int i = 1; i <= vertex; i++){
			if(!visited[i] && lst[i][start] == 1){
				big(i, visited);
				isBig++;
			}
		}
	}

	static void small(int start, boolean[] visited) {
		visited[start] = true;
		for(int i = 1; i <= vertex; i++){
			if(!visited[i] && lst[start][i] == 1){
				small(i, visited);
				isSmall++;
			}
		}
	}
}










