package dp;

import java.util.Arrays;

public class PRO_등굣길 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 4, n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution.solution(m, n, puddles));
    }
    static class Solution{
        int DIVIDE = 1_000_000_007;
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n+1][m+1];
            dp[1][1] = 1;
            for(int[] puddle : puddles) dp[puddle[1]][puddle[0]] = -1;

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(dp[i][j] == -1) continue;
                    if(dp[i-1][j] != -1) dp[i][j] = (dp[i][j] + dp[i-1][j]) % DIVIDE;
                    if(dp[i][j-1] != -1) dp[i][j] = (dp[i][j] + dp[i][j-1]) % DIVIDE;
                }
            }
            for(int[] d: dp) System.out.println(Arrays.toString(d));
            return dp[n][m] % DIVIDE;
        }
    }
}
