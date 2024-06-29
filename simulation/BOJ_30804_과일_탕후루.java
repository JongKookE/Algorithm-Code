package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_30804_과일_탕후루 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] fruits;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        fruits = new int[N];
        for(int n = 0; n < N; n++) fruits[n] = Integer.parseInt(st.nextToken());

        int left = 0;
        for(int right = 0; right < N; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2) {
                // 1 2 2 2 1 2 3 2 2 2 2 2 2 1 1 2
                // left를 지울때 같은 숫자가 연속적으로 나온 경우를 처리해줘야함
                // 처음 2를 지울때 map에서 지우고 left를 계속 업데이트 해야하기 때문에
                // if가 아닌 while 을 써야함
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
