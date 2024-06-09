package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1655_가운데를_말해요 {
    static int N;
    // 오름차순으로 정렬
    // peek 하면 가장 큰 수가 나옴
    // 최대 힙
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
    // 최소 힙
    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            int element = Integer.parseInt(br.readLine());
            if(minPq.size() == maxPq.size()) {
                maxPq.add(element);
                // 최대 힙에 넣은 후 최소 힙과 비교한다.
                // 만일 최소 힙이 비어있다면 skip
                // 최소 힙의 값과 최대 힙의 값은 항상 최소 힙이 커야하기 때문에 그렇지 않다면 스왑을 해줌
                if(!minPq.isEmpty() && maxPq.peek() > minPq.peek()){
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }
            else {
                // 최대 힙을 항상 데이터가 있는 상태이니 min에 값을 넣어준다
                minPq.add(element);
                if(maxPq.peek() > minPq.peek()){
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }
            sb.append(maxPq.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
