package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382_방향_전환 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			int res = 0;
			
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int addX = 0;
			if(x1 > 0) {
				while(x1 != 0 ) {
					x1--;
					addX--;
				}				
			}
			else {
				while(x1 != 0 ) {
					x1++;
					addX++;
				}	
			}
			int addY = 0;
			if(y1 > 0) {
				while(y1 != 0 ) {
					y1--;
					addY--;
				}				
			}
			else {
				while(y1 != 0 ) {
					y1++;
					addY++;
				}	
			}

			x2 += addX;
			y2 += addY;		
			
			x2 = Math.abs(x2);
			y2 = Math.abs(y2);
			
			while(true) {
				if(x2 == 0 || y2 == 0) break;
				x2--;
				y2--;
				res++;
			}
			res *= 2;
			
			int dist = Math.max(x2, y2);
			if(dist % 2 == 0) res += dist * 2;
			else res += dist * 2 -1;
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);

	}

}
