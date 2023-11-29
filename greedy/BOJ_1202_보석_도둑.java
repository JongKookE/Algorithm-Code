package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석_도둑 {
	static int jewerly, bagSize, result;
	static int[] bag;
//	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static Node[] nodes;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		jewerly = Integer.parseInt(st.nextToken());
		bagSize = Integer.parseInt(st.nextToken());
		bag = new int[bagSize];
		nodes = new Node[jewerly];
		
		for(int i = 0; i < jewerly; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(weight, cost);
		}
		
		for(int b = 0; b < bagSize; b++) bag[b]= Integer.parseInt(br.readLine());
		
		
		
		System.out.println(result);
		
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
			if(o.cost == this.cost) return this.weight - o.weight;
			return o.cost - this.cost;
		}
		
		
		
	}
}
