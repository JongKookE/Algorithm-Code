package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {

	static int[] dx = {1, -1, 0 ,0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] house;
	static int m, n;
	static Queue<Node> queue = new ArrayDeque<Node>(); 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		house = new int[n][m];
		
		for(int i = 0; i < n; i++){
			StringTokenizer tomato = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++){
				house[i][j] = Integer.parseInt(tomato.nextToken());
				if(house[i][j] == 1) queue.offer(new Node(i, j));
			}
		}
		
		bfs();
		
		int result = 0;
		int maxDay = 0;
		
		for(int[] var : house){
			for(int variable : var){
				if(variable == 0) {
					System.out.println(-1);
					return;			
				}
				maxDay = Math.max(maxDay, variable);
			}
			
		}
		
		System.out.println(maxDay-1);
	}
	
	static void bfs(){
		while(!queue.isEmpty()){
			Node node = queue.poll();
			int y = node.y;
			int x = node.x;
			
			for(int i = 0; i <4; i++){
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= m || house[ny][nx] != 0) continue;
				house[ny][nx] = house[y][x] + 1;
				queue.offer(new Node(ny, nx));
			}
		}
	}
	static class Node{
		int y, x;
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}		
	}
}
