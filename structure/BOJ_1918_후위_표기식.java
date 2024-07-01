package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1918_후위_표기식 {
    static StringBuilder sb = new StringBuilder();
    static Deque<Character> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLetter(ch)) sb.append(ch);
            else if (ch == '(') stack.addLast(ch);
            else if (stack.isEmpty()) stack.addLast(ch);
            else if (ch == ')') {
                while(!stack.isEmpty()){
                    char element = stack.pollLast();
                    if(element == '(') break;
                    sb.append(element);
                }
            }
            // 방금 들어온 연산자와 스택의 값을 비교
            // 만일 스택에 있는 연산자의 우선순위가 더 클 경우 출력
            else if(definePrecedure(stack.peekLast()) >= definePrecedure(ch)){
                // 스택의 연산자가 우선순위가 클때 값을 뺀 후
                // 값을 뺀 이후의 스택의 연산자와 비교를 반복
                // 값을 빼면서 스택이 빌수도 있기 때문에 isEmpty 확인을 해주어야함
                while(!stack.isEmpty() && definePrecedure(stack.peekLast()) >= definePrecedure(ch)) sb.append(stack.pollLast());
                stack.addLast(ch);
            }
            else stack.addLast(ch);
        }
        while(!stack.isEmpty()) sb.append(stack.pollLast());
        System.out.println(sb);
    }
    static int definePrecedure(char ch){
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}