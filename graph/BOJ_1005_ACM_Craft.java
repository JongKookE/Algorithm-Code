package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1005_ACM_Craft {
	static int[] dist, temp;
	static ArrayList<ArrayList<Node>> lst;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			lst = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			temp = new int[N+1];
			dist = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n <= N; n++) {
				lst.add(new ArrayList<>());
				if (n==0) continue;
				temp[n] = Integer.parseInt(st.nextToken());
			}										
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				lst.get(to).add(new Node(from, temp[k+1]));
			}
			int destination = Integer.parseInt(br.readLine());
//			printLst();
			
			dijkstra(destination);
		}
		
	}
	
	static void dijkstra(int destination) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Node(1, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[dist.length];
		dist[1] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();			
			int currentVertex = node.x;
			int currentCost = node.cost;
			
			if(visited[currentVertex]) continue;
			visited[currentVertex] = true;
			
			for(Node nextNode : lst.get(currentVertex)) {
				if(!visited[nextNode.x] && dist[nextNode.x] > currentCost + nextNode.cost) {
					dist[nextNode.x] = currentCost + nextNode.cost;
					pq.add(new Node(nextNode.x, currentCost + nextNode.cost));
				}
			}
		}
		printDist();
		System.out.println(dist[destination]);
		
	}
	static void printDist() {
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(visited));
	}
	
	static void printLst() {
		System.out.println(lst.get(1).get(0).x);
		for(ArrayList<Node> l : lst) {
			System.out.print("ArrayList: ");
			for(Node node : l) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}
	static class Node{
		int x, cost;

		public Node(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", cost=" + cost + "]";
		}
	}
}
