package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ELICE_문자열_압축_해제 {
    static String str;
    static Deque<Character> stack = new ArrayDeque<>();
    static Deque<Character> makeString = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int current = 0;
        while(current < str.length()) {
            char ch = str.charAt(current);
            if(ch == ')') {
                while(!stack.isEmpty()) {
                    char poll = stack.pollLast();
                    if(poll == '(') break;
                    makeString.push(poll);
                }
                stringToStack();
            }
            else stack.addLast(ch);
            current++;
        }
        System.out.println(stack.size());
    }

    static void stringToStack(){
        StringBuilder returnString = new StringBuilder();
        StringBuilder str = new StringBuilder();
        while(!makeString.isEmpty()) {
            str.append(makeString.pollFirst());
        }
        int count = Integer.parseInt(String.valueOf(stack.pollLast()));
        for(int i = 0; i < count; i++) returnString.append(str);
        for(int i = 0; i < returnString.length(); i++) stack.addLast(returnString.charAt(i));
    }
}
