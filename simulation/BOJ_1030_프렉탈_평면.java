package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1030_프렉탈_평면 {
    static int time, frec, black, r1, r2, c1, c2;
    static int MAX_SIZE;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        frec = Integer.parseInt(st.nextToken());
        black = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        MAX_SIZE = (int) (Math.pow(frec, 5)) -1;

        // size 는 결과값과 상관없는 프렉탈 평면의 크기
        int size = (int) Math.pow(frec, time);

        if(time == 0){
            System.out.println(0);
            return;
        }

        map = new int[size][size];

        preMappingArea(size, 0, 0);



    }
    static void preMappingArea(int currentSize, int x, int y){
        if(currentSize == 1) {

        }

    }

}
