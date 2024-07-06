package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903_카드_합체_놀이 {
    static int N, M;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) pq.add(Long.parseLong(st.nextToken()));

        while(!pq.isEmpty() && M-- > 0) {
            PriorityQueue<Long> tpq = new PriorityQueue<>();
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a+b);
            pq.add(a+b);
        }
        long sum = 0;

        while(!pq.isEmpty()) sum += pq.poll();
        System.out.println(sum);

    }
}
