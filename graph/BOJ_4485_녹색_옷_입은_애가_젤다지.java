package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색_옷_입은_애가_젤다지 {
	static int[][] map;
	static int T;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while(true) {
			T = Integer.parseInt(br.readLine());
			if(T == 0) {
				System.out.println(sb);
				break;
			}
			map = new int[T][T];
			
			for(int i = 0; i < T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < T; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}						
			
			sb.append("Problem ").append(cnt).append(": ").append(dijkstra()).append("\n");	
			cnt++;
		}
	}

	static int dijkstra() {
		int[][] cost = new int[T][T];
		for(int i = 0; i < T; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
		cost[0][0] = map[0][0];
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, map[0][0]));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= T || nx >= T) continue;
				if(cost[ny][nx] >  map[ny][nx] + node.cost) {
					cost[ny][nx] = map[ny][nx] + node.cost;
					queue.offer(new Node(ny, nx, cost[ny][nx]));
				}
			}
		}
		return cost[T-1][T-1];
	}
	static class Node implements Comparable<Node>{
		int y, x, cost;

		public Node(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cost=" + cost + "]";
		}
		
		
	}
}
