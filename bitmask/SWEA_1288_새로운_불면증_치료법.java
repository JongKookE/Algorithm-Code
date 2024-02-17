package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA_1288_새로운_불면증_치료법 {
    static int T, total = (1 << 10);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        System.out.println(total);
        for(int test_case = 1; test_case <= T; test_case++){
            int sheep = Integer.parseInt(br.readLine());

//            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
