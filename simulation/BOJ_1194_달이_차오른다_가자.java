package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이_차오른다_가자 {
	static char[][] chr;
	static boolean[][][] visited;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static int col, row;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 col = Integer.parseInt(st.nextToken());
		 row = Integer.parseInt(st.nextToken());
		 
		 chr = new char[col][row];
		 // 열쇠를 가지고 있는지 없는 확인하기 위함
		 // 6개가 아니고 7개인 이유는 열쇠가 없을때 여기를 들렸다라는 뜻임
		 visited = new boolean[col][row][7];
		 
		 for(int i = 0; i < col; i++) chr[i] = br.readLine().toCharArray();
		 for(int i = 0; i < col; i++) {
			 for(int j = 0; j < row; j++) {
				 if(chr[i][j] == '0') {
					 getMoon(i, j);
					 return;
				 }
			 }
		 }
		 
		 
	}
	static int getMoon(int y, int x) {
		Queue<Node> queue = new ArrayDeque<>();
		ArrayList<Character> keys = new ArrayList<>();
		queue.offer(new Node(y, x, 0, keys));
		int count = 0;
		visited[y][x][0] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= row || ny >= col || chr[ny][nx] == '#' ) continue;
				
				if(chr[ny][nx] == '0') return node.depth + 1;
				// 현재 노드의 키 배열에 해당하는 키가 없다면...
				if(chr[ny][nx] == 'A' || chr[ny][nx] == 'B' || chr[ny][nx] == 'C'
						|| chr[ny][nx] == 'D' || chr[ny][nx] == 'E' || chr[ny][nx] == 'F')
					if(!node.key.contains(Character.toLowerCase(chr[ny][nx]))) continue;
				
				
				
				if(chr[ny][nx] == 'a' || chr[ny][nx] == 'b' || chr[ny][nx] == 'c'
						|| chr[ny][nx] == 'd' || chr[ny][nx] == 'e' || chr[ny][nx] == 'f') {
					node.key.add(chr[ny][nx]);
					
					// 키는 1부터 시작하기 때문임! 그래서 b를 빼는거야~~				
					visited[ny][nx][chr[ny][nx] - 'b'] = true;
					queue.offer(new Node(ny,nx, count, node.key));
				}	
				else {
					visited[ny][nx][0] = true;
					queue.offer(new Node(ny,nx, count, node.key));
				}
			}
			count++;
		}
		return -1;
	}
	
	static class Node{
		int y, x, depth;
		ArrayList<Character> key;
		
		public Node(int y, int x, int depth, ArrayList<Character> key) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.key = key;
		}
		
		
		
		
	}
}
