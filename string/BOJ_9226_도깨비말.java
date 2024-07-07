package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9226_도깨비말 {
    static char[] moums = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            StringBuilder first = new StringBuilder();
            StringBuilder second = new StringBuilder();


            if (s.equals("#")) break;
            for(int i = 0; i < s.length(); i++) {
                if(!contains(s.charAt(i))) {
                    second.append(s.charAt(i));
                    continue;
                }
                for(int j = i; j < s.length(); j++) first.append(s.charAt(j));
                break;

            }
            first.append(second).append("ay");
            System.out.println(first);
        }
    }
    static boolean contains(char ch) {
        for(int i = 0; i < moums.length; i++) {
            if(moums[i] == ch) return true;
        }
        return false;
    }
}
