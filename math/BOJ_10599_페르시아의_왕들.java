package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10599_페르시아의_왕들 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int birthMax = Integer.MIN_VALUE, deathMax = Integer.MIN_VALUE;
            int birthMin = Integer.MAX_VALUE, deathMin = Integer.MAX_VALUE;
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 2; i++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 0) cnt++;
                birthMax = Math.max(birthMax, value);
                birthMin = Math.min(birthMin, value);
            }
            for(int i = 0; i < 2; i++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 0) cnt++;
                deathMax = Math.max(deathMax, value);
                deathMin = Math.min(deathMin, value);
            }
            if(cnt == 4) return;
            System.out.printf("%d %d\n", deathMin - birthMax, deathMax - birthMin );
//            System.out.printf("%d %d %d %d\n", birthMin,birthMax, deathMin,deathMax );
        }
    }
}
