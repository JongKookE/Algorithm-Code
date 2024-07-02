package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {
    static int N, length;
    static int row = 2;
    static int[][] dp, stickers;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        while(N-- > 0){
            length = Integer.parseInt(br.readLine());

            dp = new int[row+1][length+1];
            stickers = new int[row+1][length+1];

            // 스티커 초기화
            for(int i = 1; i < row+1; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j < length+1; j++){
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(getDp());
        }

    }
    static int getDp(){
        dp[1][1] = stickers[1][1];
        dp[2][1] = stickers[2][1];

        for(int i = 2; i < length+1; i++){
            dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + stickers[1][i];
            dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[2][i];
        }


        return Math.max(dp[1][length], dp[2][length]);
    }
}
