package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
    static int n, destination, INF = Integer.MIN_VALUE;
    static int[] distance;
    static ArrayList<ArrayList<Node>> lst = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        distance = new int[n+1];
        for(int i = 0; i <= n; i++) lst.add(new ArrayList<Node>());
        Arrays.fill(distance, INF);
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(end - start > dist) lst.get(start).add(new Node(end, dist));
        }
        System.out.println(lst);
    }

    static void dijkstra(){

    }
    static class Node{
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
