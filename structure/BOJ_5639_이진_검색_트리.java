package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_5639_이진_검색_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> lst = new ArrayList<>();
        while(true){
            String str = br.readLine();
            if(str.isEmpty()) break;
            int value = Integer.parseInt(str);
            lst.add(value);
        }
        Collections.sort(lst);
        System.out.println(lst);
        int[] tree = new int[lst.size()-1];


    }
}
