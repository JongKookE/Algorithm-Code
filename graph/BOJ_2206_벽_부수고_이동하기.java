package graph;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽_부수고_이동하기 {
    static int vertex, edge;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        int[][] map = new int[vertex][edge];
        int[][][] visited = new int[vertex][edge][2];

        for (int i = 0; i < vertex; i++) {
            String line = br.readLine();
            for (int j = 0; j < edge; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0, 1, 0 }); // x, y, distance, isBroken
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            int isBroken = current[3];

            if (x == vertex - 1 && y == edge - 1) {
                System.out.println(distance);
                return;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < vertex && ny >= 0 && ny < edge) {
                    if (visited[nx][ny][isBroken] == 0) {
                        if (map[nx][ny] == 0) {
                            queue.add(new int[] { nx, ny, distance + 1, isBroken });
                            visited[nx][ny][isBroken] = 1;
                        } else {
                            if (isBroken == 0) {
                                queue.add(new int[] { nx, ny, distance + 1, 1 });
                                visited[nx][ny][1] = 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
=======
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_踰�_遺��닔怨�_�씠�룞�븯湲� {
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
//				System.out.println(j + "踰덉㎏ �씠以� 諛섎났臾몄엯�땲�떎.");
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
			
			// 吏�湲� �깮媛곹빐蹂대㈃ �씠嫄� 臾댁“嫄� 0怨� 1濡� �굹�늻�뼱�졇�꽌 援녹씠 �겢�옒�뒪�뿉 �꽔吏� �븡�븯�뼱�룄 �맆�벏			
			boolean nodeIsBroken = node.isBroken;
			
			if(nodeX == row - 1 && nodeY == col - 1) {
				System.out.println(nodeDistance);
				return;
			}
			

			for(int d = 0; d < 4; d++) {
				int nx = nodeX + dx[d];
				int ny = nodeY + dy[d];
				if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
				// 踰쎌쓣 留뚮굹吏� �븡�쑝硫�
				if(map[ny][nx] == 0) {
					// 踰쎌쓣 �븳踰덈룄 遺��닔吏� �븡�븯�쓣 �븣
					if(!visited[ny][nx][0] && !nodeIsBroken) {
						queue.offer(new Node(ny,nx, nodeDistance + 1, false));
						visited[ny][nx][0] = true;
					}
					// 踰쎌쓣 遺��닚�쟻�씠 �엳�쓣 �븣 
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
//	// 踰쎌쓣 �씠誘� �븳踰� 遺��닔�뿀�떎.
//	else if(visited[ny][nx][0]){
//		queue.offer(new Node(ny, nx, nodeDistance + 1, 1));
//		visited[ny][nx][0] = true;
//	}
//}
>>>>>>> 4da1af844a51d21a8da19d9576fb8da18dbb8c80
