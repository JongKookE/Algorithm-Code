package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ_1197_ÃÖ¼Ò_½ºÆĞ´×_Æ®¸® {

	static int node, edge;
	static int[] parents;
	static ArrayList<Node> nodeList;
	public static void main(String[] args) throws Exception {
=======
import java.util.StringTokenizer;

public class BOJ_1197_ìµœì†Œ_ìŠ¤íŒ¨ë‹_íŠ¸ë¦¬ {
	static int vertex, edge;
	static int[] parents;
	static ArrayList<Node> nodeList;
	static ArrayList<Node> graph;
	public static void main(String[] args) throws IOException{
>>>>>>> 4da1af844a51d21a8da19d9576fb8da18dbb8c80
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
<<<<<<< HEAD


		parents = new int[node+1];
		nodeList = new ArrayList<>();


		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			//from¹ø Á¤Á¡°ú to¹ø Á¤Á¡ÀÌ °¡ÁßÄ¡ costÀÎ °£¼±À¸·Î ¿¬°áµÇ¾î ÀÖ´Ù
			nodeList.add(new Node(from,to, cost));
		}

		Collections.sort(nodeList);

		make();

		int sum = 0;
		int cnt = 0;

		for(Node n : nodeList) {
			if(union(n.from, n.to)){
				sum += n.cost;
				cnt++;

				if(cnt==edge-1) break;
			}
		}

		System.out.println(sum);
	}

	private static boolean union(int from, int to) {

		int fromRoot = findSet(from);
		int toRoot = findSet(to);

		if(fromRoot==toRoot) return false;
		else parents[toRoot] = fromRoot;
		return true;
=======
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
		
		
>>>>>>> 4da1af844a51d21a8da19d9576fb8da18dbb8c80
	}

	private static int findSet(int v) {

		if(parents[v]==v) return v;
		else return parents[v] = findSet(parents[v]);
	}

	private static void make() {
		for(int i = 1 ; i <= node ; i++) {
			parents[i] = i;
		}
	}

	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}



		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}


}
