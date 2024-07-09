class Solution {
    public int[] solution(int[] sequence, int k) {
        int MIN = Integer.MAX_VALUE;

        int[] answer = new int[2];
        int start = 0; int end = 1;
        int limit = sequence.length;
        int sum = sequence[start];
        while(start < end){
            // 두 인덱스의 값이 k와 같을 때
            if(sum == k){
                if(MIN > end - start) {
                    MIN = end - start;
                    answer[0] = start;
                    answer[1] = end-1;
                }
                sum -= sequence[start++];
            }
            // 목표값보다 커서 start와 end의 간격을 줄어야할때
            else if(sum > k){
                sum -= sequence[start++];
            }
            else if (end < limit){
                sum += sequence[end++];
            }
            else break;

        }
        return answer;
    }
}