package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(isPalindrome(start, end)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb.toString());
    }
    static boolean isPalindrome(int start, int end){
        if (start == end) return true;

        // 1 2 1
        if((end-start+1) % 2 != 0) {
            while (start != end) {
                if (arr[start] != arr[end]) return false;
                start++;
                end--;
            }
        }
        else {
            while (end-start != -1) {
                if (arr[start] != arr[end]) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}
