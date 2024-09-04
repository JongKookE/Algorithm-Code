package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PRO_줄_서는_방법 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int k = 15;
        System.out.println(Arrays.toString(solution.solution(n, k)));
    }
}

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }

        k--;
        int cnt = 0;
        while(n > 0){
            factorial /= n--;
            answer[cnt++] = list.get((int) (k/factorial));
            list.remove((int) (k/factorial));
            k %= factorial;
        }
        return answer;
    }
}