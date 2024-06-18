package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕_신해빈 {
    static int N;
    static StringTokenizer st;
    static HashMap<String, Integer> fashion;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++){
            int K = Integer.parseInt(br.readLine());
            fashion = new HashMap<>();
            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                fashion.put(type, fashion.getOrDefault(type, 0) + 1);
            }
            System.out.println(comb());
        }
    }
    static int comb(){
        int sum = 1;
        for (int value : fashion.values()) sum *= (value+1);


        return sum-1;
    }
}
