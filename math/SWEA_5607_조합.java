package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {
	static final int mod = 1234567891;
    static long factorial[] = new long[1000001];
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		factorial[0] = 1;
	    for(int i=1; i<=1000000; i++) factorial[i] = factorial[i-1] * i % mod;
	        
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			long a = factorial[N];
            long b = (factorial[N-K] * factorial[K]) % mod;
            long c = calculatePow(b, mod-2);
            
            sb.append("#").append(t).append(" ").append(a * c % mod).append("\n");
		}
		System.out.println(sb);
	}
	static long calculatePow(long n, long k) {
		if( k == 1) return n;
		long x = calculatePow(n, k/2) % mod;
		if(k % 2 == 0) return x * x % mod;
		else return ((x*x) % mod * n) % mod;
	}
}
