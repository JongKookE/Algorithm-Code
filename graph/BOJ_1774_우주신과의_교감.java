package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1774_우주신과의_교감 {
    static int N, M;
//    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static ArrayList<Node> list = new ArrayList<>();
    static ArrayList<Node> coordinates = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];

        for(int n = 1; n <=N; n++) parents[n] = n;

//        for(int m = 0; m <= M; m++) list.add(new ArrayList<>());

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            coordinates.add(new Node(start, end));
        }

//        System.out.println(coordinates);

        for(int i = 1; i <= N; i++){
            for(int j = i+1; j <= N; j++){
//                if(i == j) continue;
                Node start = coordinates.get(i-1);
                Node end = coordinates.get(j-1);
                double distance = euclid(start.end, end.end, start.start, end.start);
                pq.add(new Node(i, j, distance));
            }
        }
        Collections.sort(list);
//        System.out.println(list);

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(union(a, b)) parents[a] = b;

        }


        double result = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(union(node.start, node.end)){
                result += node.cost;
            }
        }

        System.out.printf("%.2f", result);
    }
    static double euclid(int y1, int y2, int x2, int x1){
        return Math.pow((Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2)), 0.5);
    }

    static int find(int v){
        if(parents[v] == v) return v;
        else return parents[v] = find(parents[v]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        else parents[aRoot] = bRoot;

        return true;
    }

    static class Node implements Comparable<Node>{
        int start, end;
        double cost;

        public Node(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(cost, o.cost);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }
}
