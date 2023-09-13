package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽_부수고_이동하기 {
	static int col, row, map[][];
	static boolean[][] visited;
	static int[] dx = {-1,1, 0, 0}, dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		visited = new boolean[col][row];

		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (map[i][j] == 0)
					bfs(i, j);
			}
		}

	}

	static void bfs(int y, int x) {
		Queue<Node> queue = new ArrayDeque<>(	);
		queue.offer(new Node(y, x));
		visited[y][x] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int nodeX = node.x;
			int nodeY = node.y;
			
			for(int d = 0; d < 4; d++) {
				int nx = nodeX + dx[d];
				int ny = nodeY + dx[y];
				if
			}
		}
	}
	
	static class Node{
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
