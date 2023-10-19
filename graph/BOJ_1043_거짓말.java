package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1043_거짓말 {
	static int vertex, edge, known;
	static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
	static ArrayList<Integer> already;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		known = Integer.parseInt(st.nextToken());
		

		if(known == 0) {
			System.out.println(edge);
			return;
		}
		// 진실을 아는 사람의 수와 해당되는 사람
		already = new ArrayList<>();
		for(int k = 0; k < known; k++) already.add(Integer.parseInt(st.nextToken()));			
	
		
		// ArrayList 초기화
		for(int l = 0; l <= edge; l++) lst.add(new ArrayList<>());
		
		// 그래프 생성
		for(int i = 1; i <= edge; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int c = 0; c < cnt; c++) lst.get(i).add(Integer.parseInt(st.nextToken()));						
		}
				
	}
	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[known+1];
	}
}
