package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽_부수고_이동하기 {
	static int col, row, map[][];
	static boolean[][][] visited;
	static int[] dx = {-1,1, 0, 0}, dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		visited = new boolean[col][row][2];

		for (int i = 0; i < col; i++) {
			char[] chr = br.readLine().toCharArray();			
			for (int j = 0; j < row; j++) {
//				System.out.println(j + "번째 이중 반복문입니다.");
				map[i][j] = chr[j] - '0';
			}
		}

		bfs(0, 0, 1, false); 
//		System.out.println(Arrays.deepToString(a));

	}

	static void bfs(int y, int x, int distance, boolean isBroken) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(y, x, distance, isBroken));
//		visited[0][0][0] = true;	
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int nodeX = node.x;
			int nodeY = node.y;
			int nodeDistance = node.distance;
			
			// 지금 생각해보면 이건 무조건 0과 1로 나누어져서 굳이 클래스에 넣지 않았어도 될듯			
			boolean nodeIsBroken = node.isBroken;
			
			if(nodeX == row - 1 && nodeY == col - 1) {
				System.out.println(nodeDistance);
				return;
			}
			

			for(int d = 0; d < 4; d++) {
				int nx = nodeX + dx[d];
				int ny = nodeY + dy[d];
				if(nx > 0 || ny > 0 || nx <= row || ny <= col) continue;
				// 벽을 만나지 않으면
				if(map[ny][nx] == 0) {
					// 벽을 한번도 부수지 않았을 때
					if(!visited[ny][nx][0] && !nodeIsBroken) {
						queue.offer(new Node(ny,nx, nodeDistance + 1, false));
						visited[ny][nx][0] = true;
					}
					// 벽을 부순적이 있을 때 
					else if(!visited[ny][nx][1] && nodeIsBroken) {
						queue.offer(new Node(ny,nx, nodeDistance + 1, true));
						visited[ny][nx][1] = true;
					}
				}
				else if (map[ny][nx] == 1) {
					if(!nodeIsBroken) {
						queue.offer(new Node(ny, nx, nodeDistance + 1, true));
						visited[ny][nx][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
}
		
	
	static class Node{
		int y, x, distance;
		boolean isBroken;
		
		public Node(int y, int x, int distance, boolean isBroken) {
			super();
			this.y = y;
			this.x = x;
			this.distance = distance;
			this.isBroken = isBroken;
		}

	
	}
}





//if(visited[ny][nx][0]) {
//	if(map[ny][nx] == 0)
//	if(!visited[ny][nx][0]) {
//		queue.offer(new Node(ny, nx, nodeDistance + 1, 0));
//		visited[ny][nx][0] = false;
//	}
//	// 벽을 이미 한번 부수었다.
//	else if(visited[ny][nx][0]){
//		queue.offer(new Node(ny, nx, nodeDistance + 1, 1));
//		visited[ny][nx][0] = true;
//	}
//}
