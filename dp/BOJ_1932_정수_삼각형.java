package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수_삼각형 {
    static int[][] dp;
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                dp[n][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int size = N-1; size >= 1; size--){
            for(int l = 1; l <= size ; l++){
                dp[size][l] = Math.max(dp[size+1][l] + dp[size][l], dp[size+1][l+1] + dp[size][l]);
            }
        }
        System.out.println(dp[1][1]);
    }
}
