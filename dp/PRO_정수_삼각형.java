package dp;

public class PRO_정수_삼각형 {
    public static void main(String[] args) {
        int[][] triangle =  {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Solution solution = new Solution();
        System.out.println(solution.solution(triangle));
    }
    static class Solution {
        public int solution(int[][] triangle) {
            int size = triangle.length;
            for(int i = size-2; i >= 0; i--){
                int depthSize = triangle[i].length;
                for(int j = 0; j < depthSize; j++)
                    triangle[i][j] = Math.max(triangle[i][j] + triangle[i+1][j], triangle[i][j] + triangle[i+1][j+1]);
            }
            return triangle[0][0];
        }
    }

}
