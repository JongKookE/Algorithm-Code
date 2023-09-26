import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class PGS_표_편집 {
    public String solution(int n, int k, String[] cmd){
        String answer = "";
        ArrayList<Integer> remain = new ArrayList<>();
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        // 현재 선택된 곳은 스택1의 제일 마지막 원소임
        for(int i = 0; i <= k; i++) stack1.add(i);
        for(int i = k + 1; i < n; i++) stack2.add(i);

        for(int i = 0; i <n; i++){
            if (cmd[i].length() == 1) {
                // Z 또는 C임
                if(cmd[i].charAt(0) == 'C'){
                    if(stack2.isEmpty()) stack2.pollLast();
                    else {

                        stack1.pollLast();
                        stack1.addLast(stack2.pollFirst());
                    }

                }
            }
        }

        

        return answer;
    }
}

class Node{
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}