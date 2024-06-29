package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과_사다리_게임 {
    static StringTokenizer st;
    static boolean[] visited;
    static int[] boards;
    static HashMap<Integer, Integer> snakeAndLadderPositions = new HashMap<>();
    static int L, S;
    static final int HUNDRED = 100;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[HUNDRED + 1];
        boards = new int[HUNDRED + 1];
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        for (int i = 0; i < L + S; i++) {
            st = new StringTokenizer(br.readLine());
            int startPosition = Integer.parseInt(st.nextToken());
            int endPosition = Integer.parseInt(st.nextToken());
            snakeAndLadderPositions.put(startPosition, endPosition);
        }
        System.out.println(reachTargetScore());

    }
    static int reachTargetScore(){
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()){
            int currentPosition = queue.poll();
            for(int i = 1; i <= 6; i++){
                int nextPosition = currentPosition + i;
                if(nextPosition > HUNDRED) continue;
                if(visited[nextPosition]) continue;
                // 사다리 또는 뱀에게 걸렸을 때
                if(snakeAndLadderPositions.containsKey(nextPosition)){
                    int reachedPosition = snakeAndLadderPositions.get(nextPosition);
                    if(visited[reachedPosition]) continue;
                    visited[reachedPosition] = true;
                    boards[reachedPosition] = boards[currentPosition] + 1;
                    queue.add(reachedPosition);
                }
                else {
                    boards[nextPosition] = boards[currentPosition] + 1;
                    visited[nextPosition] = true;
                    queue.add(nextPosition);
                }

                if(visited[HUNDRED]) return boards[HUNDRED];

            }
        }

        return 0;
    }
}
