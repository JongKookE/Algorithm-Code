package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인_해킹 {
    static int vertex, edge, max;
    static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        numbers = new int[vertex+1];
        for(int v = 0; v <= vertex; v++) lst.add(new ArrayList<Integer>());

        lst.clone();

        for(int e = 0; e < edge; e++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            lst.get(from).add(to);
        }
        for(int v = 1; v <= vertex; v++){
            hacking(v, new boolean[vertex+1]);
            max = Math.max(max, numbers[v]);
        }
        for(int number = 1; number < vertex+1; number++) if(max == numbers[number]) System.out.print(number + " ");



    }
    static void hacking(int start, boolean[] visited){
        visited[start] = true;
        for(int value : lst.get(start)){
            if(visited[value]) continue;
            visited[value] = true;
            numbers[value]++;
            hacking(value, visited);
        }
    }

    static class Node{
        int number, count;
        public Node(int number, int count){
            this.number = number;
            this.count = count;
        }
    }
}
