package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967_트리의_지름 {
	static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
	static boolean[] visited;
	static int N;
	static int max = Integer.MIN_VALUE;
	static StringTokenizer st;
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N == 1) {
			System.out.println(0);
			return;
		}
		for(int n=0; n <= N; n++) nodes.add(new ArrayList<>());

		for(int n = 0; n < N-1; n++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			nodes.get(from).add(new Node(to, distance));
			nodes.get(to).add(new Node(from, distance));
		}
		 for(int n = 1; n <= N; n++){
			 ArrayList<Node> nodeArrayList = nodes.get(n);
			 if(nodeArrayList.size() != 1) continue;
			 visited = new boolean[N+1];
			 dfs(n, 0);
		 }
		System.out.println(max);
	}
	static void dfs(int index, int currentDistance){
		visited[index] = true;
		for(Node node: nodes.get(index)){
			if(visited[node.to]) continue;
			visited[node.to] = true;
			dfs(node.to, currentDistance + node.dist);
		}
		max = Math.max(max, currentDistance);
	}

	static class Node{
		int to, dist;

		Node(int to, int dist){
			this.to	= to;
			this.dist = dist;
		}

	}
}
