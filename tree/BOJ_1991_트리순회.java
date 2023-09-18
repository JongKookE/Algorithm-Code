package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1991_트리순회 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[][] chr = new char[T][3];
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			chr[t] = str.toCharArray();
		}
		

	}

}
