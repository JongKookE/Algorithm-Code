package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_6064_카잉_달력 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			calender(N, M, x, y);
		}
	}
	static void calender(int N, int M, int x, int y) {
		int result = 1;
		int rx = 1;
		int ry = 1;
		while(!(x == rx && y == ry)) {
			if(rx == N && ry == M) {
				System.out.println(-1);
				return;
			}

			rx++;
			ry++;
			result++;
			
			if(rx > N) rx = 1;
			if(ry > M) ry = 1;		
			
			
			
		}
		
		System.out.println(result);
	}
}
