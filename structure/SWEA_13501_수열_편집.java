package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_13501_수열_편집 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> lst;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int operCount = Integer.parseInt(st.nextToken());
            int getOutput = Integer.parseInt(st.nextToken());
            lst = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) lst.add(Integer.parseInt(st.nextToken()));
            for(int o = 0; o < operCount; o++){
                st = new StringTokenizer(br.readLine());
                char oper = st.nextToken().charAt(0);
                switch (oper){
                    case 'I': insert(); break;
                    case 'D': delete(); break;
                    case 'C': cSwap(); break;
                    default: break;
                }
            }

            sb.append("#").append(t).append(" ");

            try{
                sb.append(lst.get(getOutput));
            }catch (Exception e){
                sb.append("-1");
            } finally {
                sb.append("\n");
            }
        }
        System.out.println(lst.clone());
        System.out.println(sb.toString());
    }
    static void insert(){
        int insertIndex = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        lst.add(insertIndex, value);
    }
    static void delete(){
        int deleteIndex = Integer.parseInt(st.nextToken());
        lst.remove(deleteIndex);
    }
    static void cSwap(){
        int swapIndex = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        lst.add(swapIndex, value);
        lst.remove(swapIndex+1);
    }
}
