package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1263_사람_네트워크2_교수님_BFS {
	static ArrayList<ArrayList<Integer>> adjList;	
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
			
			adjList = new ArrayList<>();
			for(int i = 0; i < N; i++) adjList.add(new ArrayList<>());
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n == 1) adjList.get(i).add(j);
				}
			}
			
			
			min = Integer.MAX_VALUE;
			
			// 각 정점 별로 최단경로를 구해서 min을 갱신한다.
			for(int i = 0; i < N; i++) {
				bfs(i);
			}
			
			
			
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs(int V) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		visited[V] = true;
		queue.offer(new Node(V, 0));
		int dist = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int v : adjList.get(node.v)) {
				if(visited[v]) continue;
				visited[v] = true;
				dist += node.cnt + 1;
				if(dist >= min) return;
				queue.offer(new Node(v, node.cnt + 1));
				
			}
		}
		min = Math.min(min, dist);
	}
	
	static class Node{
		int v, cnt;
		
		Node(int v, int cnt){
			this.v = v;
			this.cnt = cnt;
		}
	}

}

















