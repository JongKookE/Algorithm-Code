package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1197_최소_스패닝_트리 {
	static int vertex, edge;
	static int[] parents;
	static ArrayList<Node> nodeList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		parents = new int[edge+1];
		
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());			
			nodeList.add(new Node(from, to, cost));
		}
		
		for(int i = 1; i <= edge; i++) parents[i] = i;
		
		int sum = 0;
		int cnt = 0;
		
		for(Node n : nodeList) {
			if(union(n.from, n.to)) {
				sum += n.cost;
				cnt++;
				if(cnt == edge-1) break;
			}
		}
		System.out.println(sum);
		
	}
	
	
	static int find(int a) {
		if(find(a) == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootA] = rootB;
		return true;
		
	}
	
	static class Node{
		int from, to, cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		
	}
}
