package etc;

import java.util.*;
import java.io.*;

class ELICE_트리_위의_게임 {
    static int N;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for(int i=1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        System.out.println(list);

        int[] depth = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Deque<Integer> dq = new ArrayDeque<>();

        dq.add(1);
        visited[1] = true;

        while(!dq.isEmpty()){
            int node = dq.pollLast();
            for(int child: list.get(node)){
                if(visited[child]) continue;
                visited[child] = true;
                depth[child] = depth[node]+1;
                dq.addLast(child);
            }
        }
        System.out.println(Arrays.toString(depth));
        for(int i = 1; i <= N; i++){
            if(depth[i] % 2 == 0) System.out.println(1);
            else System.out.println(0);
        }

    }
}