package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1916_최소비용_구하기 {
	static int vertex, edge, start, end;
	static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
	static int[] dist;	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		vertex = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		
		// 2차원 그래프 생성
		for(int i = 0; i <= vertex; i++) lst.add(new ArrayList<>());
		
		for(int e = 0; e < edge; e++) {
			
		}
		
		
	}
	static class Node{
		int y, x, cost;

		public Node(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}

		public Node(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}
		
	}
}
