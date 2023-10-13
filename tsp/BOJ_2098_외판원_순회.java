package tsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2098_외판원_순회 {

	static int N, allMask, INF = 999_999_999;
	static int[][] w;
	static int[][] memoi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		
		allMask = (1 << N) - 1;
		memoi = new int[N][allMask];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0, 1));
	}
	
	static int tsp(int idx, int mask) {
		// 기저조건
		// 모든 도시를 방문한 상태이므로, 처음으로 돌아가는 비용 처리
		if(mask == allMask) {
			if(w[idx][0] == 0) return INF;
			else return w[idx][0];
		}
		
		// 도시를 더 방문해야 함
		if(memoi[idx][mask] != 0) return memoi[idx][mask];
		
		// 처음
		memoi[idx][mask] = INF;
		
		// 방문하지 않은 도시를 방문 (재귀)
		for(int i = 0; i < N; i++) {
			// 갈 수 없거나, 이미 방문한 경우는 skip
			if(w[idx][i] == 0 || (mask & 1 << i) != 0) continue;
			
			memoi[idx][mask] = Math.min(memoi[idx][mask], tsp(i, mask | (1 << i))+ w[idx][i]); 
		}
		return memoi[idx][mask];		
	}
}
