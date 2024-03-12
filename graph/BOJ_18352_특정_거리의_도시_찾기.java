package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352_특정_거리의_도시_찾기 {
    static int vertex, edge, fit, start;
    static Integer[] dist;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        fit = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        dist = new Integer[vertex+1];
        boolean[] visited = new boolean[vertex+1];

        for(int i = 0; i <= vertex; i++) list.add(new ArrayList<>());
        Arrays.fill(dist ,Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int destIndex = Integer.parseInt(st.nextToken());
            list.get(startIndex).add(new Node(destIndex, 1));
        }

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.index]) continue;
            visited[node.index] = true;
            for(Node element: list.get(node.index)){
                if(!visited[element.index] && dist[element.index] > dist[node.index] + element.cost){
                    dist[element.index] = dist[node.index] + element.cost;
                    pq.add(new Node(element.index, dist[element.index]));
                }
            }
        }
        for(int d = 1; d <= vertex; d++) if(dist[d] == fit) sb.append(d).append("\n");
        System.out.println(sb.isEmpty() ? -1 : sb.toString());
    }
    static class Node{
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
