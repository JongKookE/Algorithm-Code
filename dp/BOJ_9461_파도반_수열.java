package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9461_파도반_수열 {
    static int N, max = Integer.MIN_VALUE;
    static int[] arr;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int n = 0; n < N; n++){
            int num = Integer.parseInt(br.readLine());
            arr[n] = num;
            max = Math.max(max, num);
        }
        dp = new long[max+1];

        dp[1] = 1;
        dp[2] = 1;
        for(int m = 3; m <= max; m++) dp[m] = dp[m-2] + dp[m-3];

        for(int dp_num: arr) System.out.println(dp[dp_num]);
    }

}
