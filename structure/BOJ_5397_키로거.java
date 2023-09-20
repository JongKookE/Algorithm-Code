package structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

<<<<<<< HEAD
public class BOJ_5397_키로거 {
=======
public class BOJ_5397_키로거{
>>>>>>> f4b47cb8f01b16a05017261117bb75ce8f19d74c
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            Deque<Character> before = new ArrayDeque<>();
            Deque<Character> after = new ArrayDeque<>();
            String str = br.readLine();
            int size = str.length();
            for(int i = 0; i < size; i++){
                char chr = str.charAt(i);
                switch (chr){
                    case '>': if(!after.isEmpty()) before.addLast(after.pollFirst()); break;
                    case '<': if(!before.isEmpty()) after.addFirst(before.pollLast()); break;
                    case '-': if(!before.isEmpty()) before.pollLast(); break;
                    default: before.addLast(chr);
                }
            }
            for(char c : before) sb.append(c);
            for(char c : after) sb.append(c);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
