package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_17609_회문 {
    static int N;
    static char[] chr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());

        for(int n = 0; n < N; n++){
            chr = br.readLine().toCharArray();
            System.out.println(isPalindrome());
        }
    }
    static int isPalindrome(){
        boolean flag = true;
        int start = 0;
        int end = chr.length - 1;
        while(start <= end){
            if(chr[start] == chr[end]){
                start++;
                end--;
            }
            else if(chr[start+1] == chr[end] && flag){

            }


        }
       return 0;
    }
}
