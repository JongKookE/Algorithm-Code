package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

import graph.BOJ_11559_Puyo_Puyo.Node;

public class BOJ_11559_Puyo_Puyo {
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static char[][] field = new char[12][6];
	static int count;
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 12; i++) field[i] = br.readLine().toCharArray();
		
		for(int i = 11; i <= 0; i--) {
			for(int j = 0; j <6; j++) {
				if(field[i][j] != '.') bfs(new Node(i, j, field[i][j]));				
			}
		}
	}
	
	static void bfs(Node node) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(node);
		int overFour = 0;					
		while(!queue.isEmpty()) {
			Node firstNode = queue.poll();
			int x = firstNode.x;
			int y = firstNode.y;
			char currentColor = firstNode.color;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || ny >= 12 || nx >= 6 || field[ny][nx] == '.' || field[ny][nx] != currentColor) continue;								
				field[ny][nx] = ',';
				overFour++;
				queue.add(new Node(ny, nx));
			}
		}
		
		if(overFour >= 4) blockBroken(queue);
		else recovery(queue);
		
	}
	
	static void recovery(Queue<Node> queue) {
		while(!queue.isEmpty()) {
			Node recoveryNode = queue.poll();
			int x = recoveryNode.x;
			int y = recoveryNode.y;
			field[y][x] = '.';
		}
	}
	
	static void blockBroken(Queue<Node> queue) {
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			
		}
	}
	
	static class Node{
		int y, x;
		char color;

		public Node(int y, int x, char color) {
			super();
			this.y = y;
			this.x = x;
			this.color = color;
		}

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		

		
	}
}
