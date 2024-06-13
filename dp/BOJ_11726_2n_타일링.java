package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2n_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for(int n = 3; n <= N; n++){
            dp[n] = ((dp[n-1] % 10007) + (dp[n-2] % 10007)) % 10007;
        }
        System.out.println(dp[N]);
    }
}
