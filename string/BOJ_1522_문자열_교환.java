package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1522_문자열_교환 {
    static int aCnt;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(int i = 0; i < s.length(); i++) if(s.charAt(i) == 'a') aCnt++;

        for(int i = 0; i < s.length(); i++){
            int bCnt = 0;
            for(int j = i; j < aCnt+i; j++){
                if(s.charAt(j % s.length()) == 'b') bCnt++;
            }
            MIN = Math.min(MIN, bCnt);
        }
        System.out.println(MIN);


    }
}
