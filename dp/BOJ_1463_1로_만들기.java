package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463_1로_만들기 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        dp[1]=0;

        for(int n = 2; n <= N; n++){
            dp[n] = dp[n-1]+1;
            if(n%3 == 0) dp[n] =Math.min(dp[n],dp[n/3]+1);
            if(n%2 == 0) dp[n] =Math.min(dp[n],dp[n/2]+1);
        }
        System.out.println(dp[N]);

    }
}
