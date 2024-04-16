package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1166_선물 {
    private static int N, L, W, H;
    private static double result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        sb.append(binarySearch(0.0, Math.max(L, Math.max(W, H))));

        System.out.println(sb.toString());
    } // End of main

    private static double binarySearch(double low, double high) {
        for (int i = 0; i < 10000; i++) {
            double mid = (low + high) / 2.0;

            if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) >= N) low = mid;
            else high = mid;

        }
        return low;
    }
}