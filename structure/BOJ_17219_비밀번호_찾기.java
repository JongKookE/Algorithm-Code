package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호_찾기 {
    static StringTokenizer st;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static HashMap<String, String> passwords = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String domain = st.nextToken();
            String password = st.nextToken();

            passwords.put(domain, password);
        }
        while(M-- > 0){
            String domain = br.readLine();
            sb.append(passwords.get(domain)).append("\n");
        }
        System.out.println(sb);

    }
}
