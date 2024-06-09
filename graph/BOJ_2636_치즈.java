package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
    static int C, R, lastCheeseCnt, firstCheeseCnt;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] cheese, cheeseVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        cheese = new boolean[C][R];


        for(int c = 0; c < C; c++){
            st = new StringTokenizer(br.readLine());
            for(int r = 0; r < R; r++){
                if(st.nextToken().equals("0")) continue;
                cheese[c][r] = true;
                firstCheeseCnt++;
            }
        }

        int cnt = 0;
        int cheeseCnt = 0;

        while(firstCheeseCnt > 0){
            cheeseVisited = new boolean[C][R];
            cheeseCnt = cheeseBfs();
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(cheeseCnt);
    }

    static int cheeseBfs(){
        int lastOneCheeseCnt = 0;
        // 0,0 은 치즈가 반드시 존재하지 않음
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        cheeseVisited[0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if(!isRange(nx, ny)) continue;
                cheeseVisited[nx][ny] = true;
                // 치즈가 존재하지 않는 배열이라면 해당 좌표를 큐에 삽입
                if(!cheese[nx][ny]) queue.add(new Node(nx, ny));
                // cheese 가 존재하는 자리라는 뜻
                // cheese 가 존재하는 자리면 치즈 배열을 false 바꾸고 치즈의 수를 하나 줄임
                else{
                    cheese[nx][ny] = false;
                    lastOneCheeseCnt++;
                    firstCheeseCnt--;
                }
            }
        }
        return lastOneCheeseCnt;
    }


    // 범위안이라면 true
    static boolean isRange(int x, int y){
        return (x >= 0 && y >= 0 && x < C && y < R && !cheeseVisited[x][y]);
    }
    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
