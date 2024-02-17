package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1094_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = 64;
        int stick = Integer.parseInt(br.readLine());
        int result = 0;
        while(stick > 0){
            if(start > stick) start >>= 1;
            else {
                stick -= start;
                result++;
            }
        }
        System.out.println(result);
    }
}
