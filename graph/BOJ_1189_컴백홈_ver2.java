package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈_ver2 {
    static int col, row, num, result, count = 1;
    static boolean[][] maps;
    static int[] dy = {-1,1,0,0}, dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        maps = new boolean[col][row];
        for(int c = 0; c < col; c++){
            String str = br.readLine();
            for(int r = 0; r < row; r++) {
                if(str.charAt(r) == 'T') maps[c][r] = true;
            }
        }
        maps[col-1][0] = true;
        goHome(col-1, 0);
        System.out.println(result);
    }
    static void print(){for(boolean[] map : maps) System.out.println(Arrays.toString(map));}
    static void goHome(int y, int x){
        if(y == 0 && x == row-1){
            if(count == num){
                result++;
                return;
            }
            return;
        }

        if(result > num) return;

        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= col || nx >= row || maps[ny][nx]) continue;
            count++;
            maps[ny][nx] = true;
            goHome(ny, nx);
            maps[ny][nx] = false;
            count--;

        }
    }
    static class Node{
        int y, x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
