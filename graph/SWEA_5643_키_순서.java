package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키_순서 {
	static int T, vertex, edge;
	static ArrayList<ArrayList<Integer>> lst;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src//input//SWEA_5643_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			lst = new ArrayList<>();
			vertex = Integer.parseInt(br.readLine());
			edge = Integer.parseInt(br.readLine());
			visited = new boolean[vertex+1];
			
			for(int i = 0; i <= edge; i++) {
				lst.add(new ArrayList<Integer>());
			}
			for(int e = 1; e <= edge; e++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// a 학생이 b 학생보다 키가 작다.
				lst.get(a).add(b);
			}
//			for(int i = 0; i < lst.size(); i++) System.out.println(i + "번 " + lst.get(i));
			for(int i = 1; i <= edge; i++) chain(i);
		}
	}
	
	static void chain(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[vertex+1];
		visited[start] = true;
		queue.offer(start);
		while(!queue.isEmpty()) {
			int v = queue.poll();			
			System.out.print(v + "번 ");
			for(int node : lst.get(v)) {
				if(visited[node]) continue;				
				visited[node] = true;
				queue.offer(node);
//				System.out.print(node + " ");
			}
			
		}
		System.out.println();
	}

}










