package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911_흙길_보수하기 {
	static int line, stick;
	static ArrayList<Integer> al = new ArrayList<>();
	static Node[] map;
	static ArrayList<Node> dupMap = new ArrayList<Node>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		line = Integer.parseInt(st.nextToken());
		stick= Integer.parseInt(st.nextToken());
		map = new Node[line];
		for(int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[i] = new Node(a, b);
		}
		Arrays.sort(map);
		for(int i = 0; i < line; i++) {
			for(int j = map[i].x; j < map[i].y; j++) {
				// emptyMap의 원소가 1이면 웅덩이다.
				al.add(j, 1);
			}
		}
		
		for(Integer el : al) System.out.println(el);
		
	}
	static class Node implements Comparable<Node>{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
		
	}
}
