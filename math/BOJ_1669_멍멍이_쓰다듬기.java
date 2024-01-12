package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1669_멍멍이_쓰다듬기 {
    static int monkey, dog, diff, result = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        monkey = Integer.parseInt(st.nextToken());
        dog = Integer.parseInt(st.nextToken());
        diff = dog - monkey;

        if(diff <= 3) System.out.println(diff); return;


    }
}
