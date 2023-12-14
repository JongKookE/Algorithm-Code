public class time {
    public static void main(String[] args) {
        int max = 10000;
        long temporalStart = System.currentTimeMillis();
        int[][] matrix = new int[max][max];
        for(int i = 0; i < max; i++){
            for(int j = 0; j < max; j++){
                matrix[j][i] = 1;
            }
        }
        long temporalEnd = System.currentTimeMillis();
        System.out.printf("시간차이: %d\n", (temporalEnd - temporalStart));
    }
}
