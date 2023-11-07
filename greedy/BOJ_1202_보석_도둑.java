package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석_도둑 {
	static int jewerly, bag;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		jewerly = Integer.parseInt(st.nextToken());
		bag = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < jewerly; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Node(weight, cost));
		}
	}
	static class Node implements Comparable<Node>{
		int weight, cost;

		public Node(int weight, int cost) {
			super();
			this.weight = weight;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [weight=" + weight + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			if(this.weight == o.weight) return this.cost - o.cost;
			else return this.weight - o.weight;
		}
		
		
		
	}
}
