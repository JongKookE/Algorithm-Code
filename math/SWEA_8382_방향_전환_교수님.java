package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382_방향_전환_교수님 {
	static int T, x1,y1, x2, y2, ans;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {			
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int x = Math.abs(x2 - x1);
			int y = Math.abs(y2 - y1);
			
			int line = (x + y)/2;
			ans = 2 * line + Math.abs(x - line) + Math.abs(y - line);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

}
