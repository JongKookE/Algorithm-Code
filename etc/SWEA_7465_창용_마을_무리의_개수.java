package etc;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7465_창용_마을_무리의_개수 {
	static int T, N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> lst;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src//input//SWEA_7465_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
						
			lst = new ArrayList<>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1];
			// N -> vertex
			// M -> edge
			for(int i = 0; i <= N; i++) lst.add(new ArrayList<>());
			
			for(int i = 1; i <= M; i++) {				
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				lst.get(from).add(to);
				lst.get(to).add(from);
			}
			int count = 0;
			for(int i = 1; i < N+1; i++) {
				if(visited[i]) continue;
				bfs(i);
				count++;
			}
			sb.append("#").append(t+1).append(" ").append(count).append("\n");
			

		}
		System.out.println(sb);
	}
	
	static void bfs(int x) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(x);
		visited[x] = true;
		while(!queue.isEmpty()) {
			int p = queue.poll();
			for(int v : lst.get(p)) {
				if(visited[v]) continue;
				visited[v] = true;
				queue.offer(v);
			}
		}
	}
	
	static void printLst() {
		for(int i = 0; i < lst.size(); i++) System.out.println(lst.get(i));
	}

}
