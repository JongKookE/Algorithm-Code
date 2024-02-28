package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두_용액 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) arr[n] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int start = 0;
        int end = N-1;

        long resultOne = 0;
        long resultTwo = 0;

        long min = Long.MAX_VALUE;

        while(start < end){
            if(arr[start] + arr[end] == 0) {
                resultOne = arr[start];
                resultTwo = arr[end];
                break;
            }

            if(Math.abs(arr[start] + arr[end]) < min) {
                resultOne = arr[start];
                resultTwo = arr[end];
                min = Math.abs(arr[start] + arr[end]);
            }

            if(arr[start] + arr[end] < 0) start++;
            else end--;

        }
        System.out.println(resultOne + " " + resultTwo);
    }
}
