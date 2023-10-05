package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리_만들기_2 {
	// 아무리 생각해도 char 배열로 바꿔야할듯...
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int col, row, landCount = 1;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		
		for(int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				int token = Integer.parseInt(st.nextToken());
				if(token == 1) map[i][j] = 7;
				else map[i][j] = 0;
			}
		}
		
		for(int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(map[i][j] == 7) {
					landMapping(i, j);			
					landCount++;					
				}
			}
		}
		for(int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static void landMapping(int y, int x) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[col][row];
		queue.offer(new Node(y, x));
		System.out.println(landCount);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				if(ny < 0 || nx < 0 || ny >= col || nx >= row || visited[ny][nx] || map[ny][nx] == 0) continue;				
				visited[ny][nx] = true;
				map[ny][nx] = landCount;
				queue.offer(new Node(ny, nx));
			}
		}
		
	}
	// bfs 를 한번 돌 때마다 모두 연결되어있는지 확인하는 과정 필요함
	// 길이가 1보다는 커야됌
	// 
	static void connectLand(int y, int x, int idx) {
		Queue<Node> queue = new ArrayDeque<>();		
		visited = new boolean[col][row];
		for(int d = 0; d < 4; d++) {
			queue.offer(new Node(y, x, 0));
			while(!queue.isEmpty()) {
				Node node = queue.poll();			
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				if(ny < 0 || nx < 0 || ny >= col || nx >= row || visited[ny][nx]) continue;
				if(map[ny][nx] != idx){
					if(map[ny][nx] != 0){
						int from = idx - 1;
						int to = map[ny][nx] - 1;
						int
					}
				}
			}
		}
	}
	
	static class Node{
		int y, x, cost;

		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
	
}
