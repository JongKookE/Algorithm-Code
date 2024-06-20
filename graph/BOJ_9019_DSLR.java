package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {
    static int N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[] commands = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int init = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            findMinimumNumber(init, goal);
        }
        System.out.println(sb);
    }
    static void findMinimumNumber(int init, int goal){
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];

        queue.add(new Node(init, ""));
        visited[init] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.num == goal){
                sb.append(node.command).append("\n");
                return;
            }

            for(char command: commands){
                int index = executeCommand(command, node.num);
                if(visited[index]) continue;
                visited[index] = true;
                queue.add(new Node(index, node.command + command));
            }
        }
    }

    static int executeCommand(char ch, int value){
        return switch (ch){
            case 'D' -> (value * 2) % 10000;
            case 'S' -> value == 0 ? 9999 : value - 1;
            case 'L' -> value % 1000 * 10 + value / 1000;
            case 'R' -> value % 10 * 1000 + value / 10;
            default -> throw new IllegalStateException("Unexpected value: " + ch);
        };
    }

    static class Node{
        int num;
        String command;

        public Node(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
}
