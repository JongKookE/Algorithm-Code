package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기_설치 {
	static int[] target, src;
	static int T, line, count, max = Integer.MIN_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		src = new int[T];
		target = new int[line];
		visited = new boolean[T];
		
		for(int t = 0; t < T; t++) src[t] = Integer.parseInt(br.readLine());
		
		comb(0, 0);
		System.out.println(max);
	}
	static void comb(int start, int cnt) {
		if(cnt == line) {
//			count++;
			int myMin = 0;
			for(int i = 0; i < line - 1; i++) {
				int sub = Math.abs(target[i] - target[i + 1]);
				max = Math.max(sub, max);
			}
			return;
		}
		for(int i = start; i < T; i++) {
			target[cnt] = src[i];
			comb(i + 1, cnt + 1);
		}
	}
}
