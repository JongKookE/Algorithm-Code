package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1740_거듭제곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long line = 1;
        long result = 0;
        while(N > 0){
            if((N & 1) == 1) result += line;
            N >>= 1;
            line *= 3;
        }
        System.out.println(result);
    }
}
