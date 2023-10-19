package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1043_거짓말 {
	static int vertex, edge, known;
	static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
	static ArrayList<Integer> already;
	static Queue<Integer> queue = new ArrayDeque<>();
	// 진실을 아는 사람은 계속되서 전파되어 증가하기 때문에 수를 알수없다.
	static ArrayList<Integer> trueMan;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		visited = new boolean[vertex];
		Queue<Integer> queue = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		known = Integer.parseInt(st.nextToken());

		int known = Integer.parseInt(st.nextToken());

		if(known == 0) {
			System.out.println(edge);
			return;
		}
		// 2차원 ArrayList 생성
		for(int i = 0; i <= vertex; i++) graph.add(new ArrayList<>());

		// 처음에 진실을 알고있던 사람 정의
		for(int i = 0; i < known; i++){
			int elem = Integer.parseInt(st.nextToken());
			queue.add(elem);
			visited[elem] = true;
		}

				
	}

}
