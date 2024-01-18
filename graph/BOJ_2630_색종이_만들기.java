package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2630_색종이_만들기 {
    static int n, white, blue;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int[][] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        maps = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        colorPaper(0, 0, n);
        System.out.println(white);
        System.out.println(blue);

    }
    static void colorPaper(int y, int x, int size){
       if(colorCheck(y, x, size)){
           if(maps[y][x] == 0) white++;
           else blue++;
           return;
       }
       int newSize = size/2;
       colorPaper(y, x, newSize);
       colorPaper(y, x + newSize, newSize);
       colorPaper(y+newSize , x, newSize);
       colorPaper(y+newSize, x+newSize, newSize );
    }

    static boolean colorCheck(int col, int row, int size){
        int color = maps[col][row];
        for(int i = col; i < col+size; i++){
            for(int j = row; j < row+size; j++) {
                if(maps[i][j] != color) return false;
            }
        }
        return true;
    }

}
