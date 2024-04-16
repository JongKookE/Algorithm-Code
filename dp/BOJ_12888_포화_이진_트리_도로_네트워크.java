package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12888_포화_이진_트리_도로_네트워크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int pow = (int) Math.pow(2, n+1) - 1;
        int div = pow/3;
        System.out.println(pow/3);
        if(3 * div < div) System.out.println(div+1);
        else System.out.println(div);
    }
}
