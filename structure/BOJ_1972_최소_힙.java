package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1972_최소_힙 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int element = Integer.parseInt(br.readLine());
            if(element != 0) pq.add(element);
            else {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
