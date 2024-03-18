package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long Z = Y * 100 / X;

        if(Z >= 99) {
            System.out.println(-1);
            return;
        }

        long start = 1;
        long end = X;

        while(start <= end){
            long mid = (start + end) / 2;
            if((Y+mid) * 100 / (X + mid) > Z) end = mid - 1;
            else start = mid+1;

        }
        System.out.println(start);
    }
}
