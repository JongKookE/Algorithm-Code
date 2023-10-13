package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_이중_우선순위_큐 {
	static int T, N;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());			
			pq = new PriorityQueue<>();
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int elem = Integer.parseInt(st.nextToken());
				
				if(command == 'I') map.put(elem, map.getOrDefault(elem, 0)+1);
				else {
					if(elem == 1) 
				}
			}
		}
			
		
		
	}

}
