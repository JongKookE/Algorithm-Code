package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
	static int C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(pow(A, B));
		
	}
	static long pow(long a, long b) {
		if(b == 1) return a % C;
		long res = pow(a, b/2);
		if(b%2 == 0) return res * res % C;
		else return (res * res % C) * a % C;
	}
}
