package structure;

import java.util.Arrays;

public class PRO_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(new Solution().solution(prices)));
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int size = prices.length;
            int[] answer = new int[size];

            for(int i = 0; i < size; i++){
                for(int j = i+1; j < size; j++){
                    answer[i]++;
                    if(prices[i] > prices[j]) break;
                }
            }
            return answer;
        }
    }
}
