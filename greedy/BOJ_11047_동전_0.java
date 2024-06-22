package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11047_동전_0 {
    static int N, goal, cnt;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        coins = new int[N];

        for(int n = N-1; n >= 0; n--) coins[n] = Integer.parseInt(br.readLine());

        for(int coin: coins){
            if(coin > goal) continue;
            cnt += goal/coin;
            goal %= coin;
        }
        System.out.println(cnt);
    }
}
