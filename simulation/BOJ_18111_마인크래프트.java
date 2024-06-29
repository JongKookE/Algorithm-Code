package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {
    static StringTokenizer st;
    static int col, row, blocks,minTime, maxHeight,tempBlocks, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[][] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        blocks = Integer.parseInt(st.nextToken());
        maps = new int[col][row];

        for(int c = 0; c < col; c++){
            st = new StringTokenizer(br.readLine());
            for(int r = 0; r < row; r++) {
                int value = Integer.parseInt(st.nextToken());
                maps[c][r] = value;
                max = Math.max(max, value);
                min = Math.min(min, value);
            }
        }
        System.out.println(makeFlatten());
    }
    public static String makeFlatten(){
        StringBuilder sb = new StringBuilder();
        minTime = Integer.MAX_VALUE;
        maxHeight = 0;
        // dest min ~ max for문 돌기
        for(int dest = min; dest <= max; dest++){
            // dest가 만들어야 하는 목표 값임
            int tempTime = 0;
            tempBlocks = blocks;
            for(int c = 0; c < col; c++){
                for(int r = 0; r < row; r++) {
                    if(chooseAction(c, r, dest)) tempTime += destroy(c, r, dest);
                    else tempTime += stack(c, r, dest);
                }
            }
            if(tempBlocks < 0) continue;

            if(minTime >= tempTime) {
                minTime = tempTime;
                maxHeight = dest;
            }
        }
        sb.append(minTime).append(" ").append(maxHeight).append("\n");

        return sb.toString();
    }
    // 블록 쌓기
    static int stack(int x, int y, int destination){
        int value = maps[x][y];
        int discount = destination - value;
        tempBlocks -= discount;
        return discount;
    }
    // 블록 파기
    static int destroy(int x, int y, int destination){
        int value = maps[x][y];
        int discount = value - destination;
        tempBlocks += discount;
        return discount*2;
    }

    // true = destroy, false = stack
    static boolean chooseAction(int x, int y, int destination){
        // 목표값보다 현재 값이 크다면 true
        return maps[x][y] > destination;
    }
}
