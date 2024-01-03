package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1005_ACM_Craft {
	static int T, N, K, dest;
	static int[] times;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<ACM>> alst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			alst = new ArrayList<>();
			for(int i = 0; i <= N; i++) alst.add(new ArrayList<>());
			times = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int n = 1; n <= N; n++) times[n] = Integer.parseInt(st.nextToken());
			for(int k = 0; k < K; k++){
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				alst.get(from).add(new ACM(to, times[to-1]));
			}
			dest = Integer.parseInt(br.readLine());
			print();
		}
	}
	static void print(){
		for(ArrayList<ACM> lst : alst){
			System.out.println(lst);
		}
	}
	static class ACM{
		int number, times;

		public ACM(int number, int times) {
			this.number = number;
			this.times = times;
		}

		@Override
		public String toString() {
			return "(" + number + " " + times + ")";
		}

	}
}