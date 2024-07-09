package etc;

import java.io.*;

class ELICE_목표량 {
    static int min = Integer.MAX_VALUE;
    static int[] src, target;
    static int N, size;
    static boolean[] chosen;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        size = str.length();
        src = new int[size];
        target = new int[size];
        chosen = new boolean[size];
        for(int i = 0; i < size; i++) src[i] = str.charAt(i) - '0';

        comb(0);
        System.out.println(min);

    }
    static void comb(int cnt){
        if(cnt == size){
            compare();
            return;
        }
        for(int i = 0; i < size; i++){
            if(chosen[i]) continue;
            chosen[i] = true;
            target[cnt] = src[i];
            comb(cnt + 1);
            chosen[i] = false;
        }
    }

    static void compare(){
        for(int t: target) sb.append(t);
        int targetNumber = Integer.parseInt(sb.toString());

        min = N < targetNumber && targetNumber < min ? targetNumber : min;
        sb.setLength(0);
    }
}