package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1708_볼록_껍질 {

	static int N;
	static long sx, sy;
	static long[][] point;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		point = new long[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		point[0][0] = Long.parseLong(st.nextToken());
		point[0][1] = Long.parseLong(st.nextToken());
		
		sx = point[0][0];
		sy = point[0][1];
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long lx = Long.parseLong(st.nextToken());
			long ly = Long.parseLong(st.nextToken());
			
			if(sy > ly) {
				sx = lx;
				sy = ly;
			} 
			else if(sy == ly && sx > lx) {
				sx = lx;
				sy = ly;
			}
			
			point[i][0] = lx;
			point[i][1] = ly;			
		}
		
		// 시작점과 두 점 p1, p2 가 만드는 ccw로 계산
		Arrays.sort(point, (p1, p2) ->{
			int ret = ccw(sx, sy, p1[0], p1[1], p2[0], p2[1]);
			if(ret >0) return -1;
			else if (ret < 0) return 1;
			else {
				long diff = distance(sx, sy, p1[0], p1[1]) - distance(sx, sy, p2[0], p2[1]);
				return diff > 0 ? 1 : -1;
			}
		});
		
		Stack<long[]> stack = new Stack<>();
		stack.add(new long[] {sx, sy});
		int length =point.length;
		for(int i = 1; i < length; i++) {
			long[] next = point[i]; 
			while(stack.size() > 1) {
				long[] first = stack.get(stack.size() - 2); // 꼭대기에서 두번째 -> 순서 1
				long[] second = stack.get(stack.size() - 1); // 꼭대기에서 첫번째 -> 순서 2
				int ret = ccw(first[0], first[1], second[0], second[1], next[0], next[1]);
				if(ret <= 0) stack.pop(); // 세컨드를 버린다.
				else break;
			}
			stack.add(point[i]);
		}
		System.out.println(stack.size());
		
	}
	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long ret = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
		if(ret > 0) return 1;
		else if (ret < 0) return -1;
		else return 0;
	}
	
	static long distance(long x1, long y1, long x2, long y2) {
		return (x1-x2) * (x1-x2) + (y1-y2)*(y1-y2);
	}
}
