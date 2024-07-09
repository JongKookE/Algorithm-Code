package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ELICE_정리_정돈을_좋아하는_K씨 {
    static int N, M;
    static StringTokenizer st;
    static int[] array;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) array[i] = Integer.parseInt(st.nextToken());

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            for(int i = start; i <= end; i++) pq.add(array[i]);

            for(int d = 0; d < destination-1; d++) pq.poll();
            System.out.println(pq.poll());
            pq.clear();
        }
    }
}
