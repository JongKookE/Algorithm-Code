package bruteforce;

import java.util.ArrayList;

public class PRO_후보키 {
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(solutsion(relation));
    }
    static int col, row, answer;
    static public int solutsion(String[][] relation) {
        row = relation.length;
        col = relation[0].length;

        return answer;
    }
    static void generateSubset(String[][] relation, boolean[] visited, int n, int idx){
        if(idx == n){
            if(isPossible()) answer++;
            return;
        }
        visited[idx] = true;
        generateSubset(relation, visited, n, idx+1);
        visited[idx] = false;
        generateSubset(relation, visited, n, idx+1);
    }
    static boolean isPossible(){
        return false;
    }
}
