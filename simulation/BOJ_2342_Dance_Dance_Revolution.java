package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2342_Dance_Dance_Revolution {
    static int[] move;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        move = new int[st.countTokens()];
        dp = new int[5][5][st.countTokens()];

    }
    static int getResult(int left, int right, int cnt){
        return 1;
    }

    static int getDance(int pos, int des){
        if(pos == 0) return 2;
        int num = Math.abs(pos - des);
        if(num == 0) return 1;
        else if(num == 1|| num ==3) return 3;
        else return 4;
    }
}
