package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458_원점으로_집합 {
	static int T, N, max;
	static int[] point;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			point = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			point[0] = Math.abs(x) + Math.abs(y);
			
			max = point[0];
			
			boolean stop = false;
			for(int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				point[i] = Math.abs(x) + Math.abs(y);
				
				max = Math.max(max, point[i]);
				
				if(point[i] % 2 != point[i-1] % 2) stop = true;
			}
			if(stop) {
				sb.append("#").append(t).append(" -1").append("\n");
				continue;
			}
			
			// 여기까지 오면 모든 점들이 원점으로 붙 ㅓ거리가 모두 짝수이거나 홀수이다.
			int sum = 0; // 움직이는 거리의 합
			int cnt = 0; // 움직이는 횟수
			
			while(true) {
				// 가장 먼 거리의 점이 이동해서 그 합이 정확하게 일치하거나, 원점을 지나서 짝수 거리에 오면 된다.
				if(sum == max || (sum > max) && (sum - max) % 2 == 0) break;
				sum += ++cnt;				
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}

