package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2178_미로_탐색 {
    static int col, row;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static StringTokenizer st;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[col][row];
        visited = new boolean[col][row];
        for(int c = 0; c < col; c++){
            char[] chs = br.readLine().toCharArray();
            for(int r = 0; r < row; r++){
                map[c][r] = chs[r] - '0';
            }
        }
        bfs();
        System.out.println(map[col-1][row-1]+1);

    }
    static void bfs(){
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0, 0));
        visited[0][0] = true;
        while(!dq.isEmpty()) {
            Node current = dq.pollLast();
            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                map[nx][ny] = current.time + 1;
                visited[nx][ny] = true;
                dq.addLast(new Node(nx, ny, map[nx][ny]));
            }
        }
    }

    static class Node{
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
