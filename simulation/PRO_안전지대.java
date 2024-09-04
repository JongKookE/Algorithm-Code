package simulation;

import java.util.Arrays;

public class PRO_안전지대 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        안전지대_Solution solution = new 안전지대_Solution();
        System.out.println(solution.solution(board));
    }
}
class 안전지대_Solution {
    int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    int n;
    boolean[][] visited;
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        visited = new boolean[n][n];
        System.out.println(Arrays.deepToString(board));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) continue;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                bfs(i, j, board);
            }
        }

        System.out.println(Arrays.deepToString(board));

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) answer++;
            }
        }
        return answer;
    }

    void bfs(int x, int y, int[][] board){
        for(int d = 0; d < 8; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(isRange(nx, ny, board)) continue;
            visited[nx][ny] = true;
            board[nx][ny] = 1;
        }
    }
    // 범위를 벗어나면 true
    boolean isRange(int x, int y, int[][] board){
        return (x < 0 || y < 0 || x >= n || y >= n || board[x][y] == 1);
    }
}