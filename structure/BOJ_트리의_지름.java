package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_트리의_지름 {
    static int n, max, maxLenNum;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i <= n; i++) lst.add(new ArrayList<>());

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int currentNumber = Integer.parseInt(st.nextToken());
            while(true){
                int nextNumber = Integer.parseInt(st.nextToken());
                if(nextNumber == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                lst.get(currentNumber).add(new Node(nextNumber, dist));
            }
        }

        visited = new boolean[n+1];
        dfs(1, 0);

        visited = new boolean[n+1];
        dfs(maxLenNum, 0);

        for(ArrayList<Node> nLst : lst) System.out.println(nLst);
        System.out.println(max);
    }

    static void dfs(int x, int len){
        if(len > max) {
            max = len;
            maxLenNum = x;
        }

        visited[x] = true;
        for(int i = 0; i < lst.get(x).size(); i++){
            Node node = lst.get(x).get(i);
            if(visited[node.num]) continue;

            dfs(node.num, node.dist+len);
            visited[node.num] = true;
        }
    }


    static class Node{
        int num, dist;
        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", dist=" + dist +
                    '}';
        }
    }
}
