package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
// 모든 노드에서 모든 노드로 방문하는데 걸리는 최소 시간을 구하는 알고리즘
// 3중 for 문으로 O(N^3)
public class BOJ_11404_플로이드 {
    // 비용은 최대 100_000
    // 그렇다고 INF 값을 100_001로 두면 안됨
    // 한 노드에 대한 비용이 최대 100_000이기 때문에 노드끼리 합해지는 경우 100_001이 넘어갈 수 있기 떄문에 더 높은 값으로 두어야 함
    private static final int INF = 100_000_000;
    static int node, edge;
    static StringTokenizer st;
    static int[][] floyd;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        floyd = new int[node+1][node+1];

        for(int i = 1; i <= node; i++){
            for(int j = 1; j <= node; j++){
                if(i == j) floyd[i][j] = 0;
                else floyd[i][j] = INF;
            }
        }

        for(int e = 0; e < edge; e++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 입력할때도 min 값을 갱신해줘야 함
            floyd[start][end] = Math.min(cost, floyd[start][end]);
        }

        // floyd warshall 시작
        for(int mid = 1; mid <= node; mid++){
            for(int start = 1; start <= node; start++){
                for(int end = 1; end <= node; end++){
                    floyd[start][end] = Math.min(floyd[start][end], floyd[start][mid] + floyd[mid][end]);
                }
            }
        }

        for(int i = 1; i <= node; i++){
            for(int j = 1; j <= node; j++){
                if(floyd[i][j] == INF) sb.append(0).append(" ");
                else sb.append(floyd[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
