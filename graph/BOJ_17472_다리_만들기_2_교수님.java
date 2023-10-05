package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리_만들기_2_교수님 {
	// 아무리 생각해도 char 배열로 바꿔야할듯...
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, min, V;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				// 바다는 0, 섬은 -1
				map[i][j] = Integer.parseInt(st.nextToken()) * -1;
			}
		}
		
		int num = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == -1 && !visited[i][j]) {
					dfs(i, j, num);
					num++;
				}
			}
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		V = num - 1; // dfs 후 마지막 증가문 고려
		
		parent = new int[V+1]; // 0 dummy
		makeSet();
		
		// 가로로 선 긋기
		hr();
		// 세로로 선 긋기
		vr();
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			// true 라면 사이클이 존재하지 않으므로 연결해야한다.
			if(union(e.v1, e.v2)) {
				cnt++;
				min += e.cost;
			}
			if(cnt == V-1) break;
		}
		if(cnt != V -1 || min == 0) min = -1;
		System.out.println(min);
	}
		
	static void addEdge(int v1, int v2, int cost) {
		boolean same = false;
		for(Edge edge : pq) {
			if(edge.v1 == v1 && edge.v2 == v2) {
				same = true;
				edge.cost = Math.min(edge.cost, cost);		
				break;
			}
		}
		if(!same) pq.offer(new Edge(v1, v2, cost));
	}
	
	static void hr() {
		for(int i = 0; i < N; i++) {
			int prev = 0;
			int curr = 0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			// 이제 옆으로 쭉 가기
			for(int j = 0; j < M; j++) {
				curr = map[i][j];
				if(prev == 0 && curr != 0) { // 0 이 아닌 좌표란 -> 이제 막 바다에서 섬으로 들어왔다.
					if(v1 == 0) v1 = curr;
					else {
						v2 = curr;
						if(cost > 1) {
							// 간선 추가 (v1, v2, cost);
							addEdge(v1, v2, cost);
						}
						// 다음 섬으로 값을 초기화 해줌
						v1 = v2;
						v2 = 0;
						cost = 0;
					}					
				}
				// 최초 시작점도 아니고, 현재 바다에 있을 때 
				else if(v1 != 0 && curr == 0){
					cost ++;
				}
				prev = curr;
			}
		}
	}
	
	static void vr() {
		for(int i = 0; i < M; i++) {
			int prev = 0;
			int curr = 0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			// 이제 옆으로 쭉 가기
			for(int j = 0; j < N; j++) {
				curr = map[j][i];
				if(prev == 0 && curr != 0) { // 0 이 아닌 좌표란 -> 바다에서 섬으로 들어온 최초 시작점
					if(v1 == 0) v1 = curr;
					else {
						v2 = curr;
						if(cost > 1) {
							// 간선 추가 (v1, v2, cost);
							addEdge(v1, v2, cost);
						}
						// 다음 섬으로 값을 초기화 해줌
						v1 = v2;
						v2 = 0;
						cost = 0;
					}					
				}
				// 최초 시작점도 아니고, 현재 바다에 있을 때 
				else if(v1 != 0 && curr == 0){
					cost ++;
				}
				prev = curr;
			}
		}
	}
	static void makeSet() {
		for(int i = 1; i <= V; i++) parent[i] = i;
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(py == px) return false; // 사이클 존재
		if(px < py) parent[py] = px;
		else parent[px] = py;
		return true;
		
	}
	
	static void dfs(int y, int x, int num) {
		visited[y][x] = true;
		map[y][x] = num;
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx]) continue;
			if(map[ny][nx] == -1) dfs(ny, nx, num);
		}
	}
	
	static class Edge{
		int v1, v2, cost;

		public Edge(int v1, int v2, int cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		
	}
}
