package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {
    static int N, vertex, edge, wormhole;
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> lst;
    static final int INF = 987654321;
    static StringBuilder sb = new StringBuilder();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while(N-- > 0 ) {
            st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            wormhole = Integer.parseInt(st.nextToken());
            lst = new ArrayList<>();
            dist = new int[vertex+1];
            for(int v = 0; v <= vertex; v++) lst.add(new ArrayList<>());

            for(int e = 0; e < edge; e++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                lst.get(from).add(new Node(to, cost));
                lst.get(to).add(new Node(from, cost));
            }
            for(int w = 0; w < wormhole; w++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                lst.get(from).add(new Node(to, -cost));
            }
            sb.append(bellmanford() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean bellmanford(){
        Arrays.fill(dist, INF);
        boolean isUpdated = false;
        // 시작점을 0으로 초기화
        // 이번 문제는 음수 사이클이 존재하는지 안하는지 판별하는 문제이기 때문에
        // 딱 한번만 벨만포드를 돌려도 성립한다.
        // 음수 사이클이 존재하는지 존재하지 않는지만 판별할것
        dist[1] = 0 ;
        // 각 정점을 시작점으로 설정하여 최단 경로를 찾기 위한 것
        // 음의 가중치로 인해서 변했을때..? 를 위해서..? 맞나..?
        for(int i = 1; i < vertex; i++){
            isUpdated = false;
            for(int j = 1; j <= vertex; j++){
                for(Node node: lst.get(j)){
                    // 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 짧은 경우
                    if(dist[node.index] > dist[j] + node.cost){
                        dist[node.index] = dist[j] + node.cost;
                        isUpdated = true;
                    }
                }
            }
            // 진행 중에 최단 거리가 하나라도 갱신되지 않을 경우 반복문 종료하는 최적화 기법
            if(!isUpdated) break;
        }
        // 최단거리가 업데이트 되었고 다시 한번 최단거리를 구할때 변동되는 값이 있다면 음수 사이클이 존재한다는 의미
        if (isUpdated) {
            for (int i = 1; i <= vertex; i++) {
                for (Node node : lst.get(i)) {
                    if (dist[node.index] > dist[i] + node.cost) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static class Node{
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
