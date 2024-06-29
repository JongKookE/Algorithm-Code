package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17626_Four_Squares {
    static int N;
    static int[] dp;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                int square = i - (j*j);
                min = Math.min(dp[square]+1, min);
            }
            dp[i] = min;
        }
        System.out.println(dp[N]);
    }
}
