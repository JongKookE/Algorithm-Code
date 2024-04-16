package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
    static int N, appleCnt, moveCnt;
    static int[][] map;
    static boolean[][] visited;
    // 왼쪽, 오른쪽, 위, 아래
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        appleCnt = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int cnt = 0; cnt < appleCnt; cnt++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 2;
        }

        moveCnt = Integer.parseInt(br.readLine());



    }
}
