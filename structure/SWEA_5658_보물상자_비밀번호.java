package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_5658_보물상자_비밀번호 {
	static int T, N, K;	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			Deque<Character> dq = new ArrayDeque<>();
			char[] chr = br.readLine().toCharArray();
			for(int c = 0; c < chr.length; c++) dq.add(chr[c]);			
			String[] FF = new String[4]; 
			for(int p = 0; p < N; p++) {
				for(int i = 0; i < 4; i++) {
					String s = "";
					for(int j = 0; j < N/4; j++) {
						char c = dq.pollFirst();
						s += c;
						dq.addLast(c);
					}
					set.add(Integer.parseInt(s, 16));
				}
				dq.addLast(dq.pollFirst());
			}
			sb.append("#").append(t+1).append(" ").append(set.toArray()[K-1]).append("\n");
		}
		System.out.println(sb);
		

	}

}
