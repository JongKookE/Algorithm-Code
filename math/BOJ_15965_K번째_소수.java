package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_15965_K번째_소수 {
    static int N, cnt;
    static final int MAX =  100_000_000;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[MAX];
        // 에라토스테네스의 체
        for(int i = 2; i < Math.sqrt(MAX); i++){
            if(visited[i]) continue;
            for(int ii = i * i; ii < MAX; ii+=i) visited[ii] = true;
        }

        for (int i = 2; i < MAX; i++) {
            // visited가 false라면 소수
            // 소수인 값을 찾을때마다 cnt를 1씩 더해가면서 찾으려고 하는 숫자인 N과 같아지는 순간 리턴
            if (!visited[i] && ++cnt == N) {
                System.out.println(i);
                return;
            }
        }
    }
}
