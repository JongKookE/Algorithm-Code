package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17472_다리_만들기_2_교수님_prim {
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, min, V;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
	// 간선 리스트
	static ArrayList<ArrayList<Edge>> vertex; // 어떤 한 정점에서 갈 수 있는 다른 정점들을 관리
	static boolean[] visitedPrim;
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

		V = num - 1; // dfs 후 마지막 증가문 고려
		vertex = new ArrayList<ArrayList<Edge>>();
		for(int i = 0; i <= V; i++) vertex.add(new ArrayList<Edge>());
		visitedPrim = new boolean[V+1];
		// 가로로 선 긋기
		hr();
		// 세로로 선 긋기
		vr();
		
		// 프림 알고리즘
		// 시작 정점은 1번부터
		int cnt = 1;
		visitedPrim[1] = true;
		// arraylist 의 1번 정점을 모두다 pq에 집어 넣음
		pq.addAll(vertex.get(cnt));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			// visited check 하고 안 가본 정점이면 다시 pq에 담는다.
			if(visitedPrim[e.v]) continue;
			visitedPrim[e.v] = true;
			pq.addAll(vertex.get(e.v));
			min += e.cost;
			cnt++;
			if(cnt == V) break;
		}
		if(cnt != V || min == 0) min = -1;
		System.out.println(min);
	}
		
	static void addEdge(int v1, int v2, int cost) {
		boolean same = false;
		for(Edge edge : vertex.get(v1)) { // v1 정점에서 갈 수 있는 다른 정점(간선) 경로 각각
			if(edge.v == v2) {
				same = true;
				edge.cost = Math.min(edge.cost, cost);		
				break;
			}
		}
		if(!same) vertex.get(v1).add(new Edge(v2, cost));
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
							addEdge(v2, v1, cost);
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
							addEdge(v2, v1, cost);
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
		int v, cost;

		public Edge(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}
	}
}
