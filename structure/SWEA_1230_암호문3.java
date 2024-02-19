package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1230_암호문3 {
    static StringTokenizer st;
    static LinkedList<String> llst;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int a = 1; a <= 10; a++){
            llst = new LinkedList<>();
            int len = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) llst.add(st.nextToken());

            int T = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                String oper = st.nextToken();

                switch (oper){
                    case "I": insert(); break;
                    case "A": add(); break;
                    case "D": delete(); break;
                    default: break;
                }
            }
            sb.append("#").append(a).append(" ");
            for(int i = 0; i < 10; i++) sb.append(llst.get(i)).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void insert(){
        int index = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int loc = index + count;
        for(int c = index; c < loc; c++){
            llst.add(c, st.nextToken());
        }
    }
    static void add(){
        int count = Integer.parseInt(st.nextToken());
        for(int c = 0; c < count; c++) llst.add(st.nextToken());
    }
    static void delete(){
        int index = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int loc = index + count;
        for(int c = index; c < loc; c++) llst.remove(index);

    }
}
