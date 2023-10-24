package ambigous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class BOJ_11053_가장_긴_증가하는_부분_수열 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		while(st.hasMoreTokens()) set.add(Integer.parseInt(st.nextToken()));
		System.out.println(set);
		System.out.println(set.size());

	}

}
