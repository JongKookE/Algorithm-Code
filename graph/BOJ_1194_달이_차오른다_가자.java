package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1194_달이_차오른다_가자 {
    static int row, col;
    static char[][] moon;
    static HashMap<Character, Node> map = new HashMap<>();
    static ArrayList<Node> keys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        moon = new char[col][row];
        for(int c = 0; c < col; c++) moon[c] = br.readLine().toCharArray();

        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; c++){
                char chr = moon[c][r];
                if(chr == 'a' || chr == 'b' || chr == 'c' || chr == 'd' || chr == 'e' || chr == 'f') map.put(chr, new Node(c, r));

            }
        }
        everyArray(moon);
    }
    static void everyArray(char[][] moon){
        for(char[] chr : moon) System.out.println(Arrays.toString(chr));
    }
    static class Node{
        int y, x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }

    }
}
