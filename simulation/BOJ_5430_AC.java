package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
    static Deque<Integer> dq = new ArrayDeque<>();
    static int T;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            String command = br.readLine();
            int arrayLength = Integer.parseInt(br.readLine());
            String dataString = br.readLine();
            char[] data = dataString.substring(1, dataString.length()-1).toCharArray();
            StringTokenizer st = new StringTokenizer(new String(data), ",");

            while(st.hasMoreTokens()) dq.addLast(Integer.parseInt(st.nextToken()));
            boolean dir = true;
            boolean isEnd = true;
            for(int c = 0; c < command.length(); c++){
                char mission = command.charAt(c);
                switch (mission) {
                    case 'R' -> {
                        dir = !dir;
                    }
                    // true 라면 정방향
                    // false 라면 역방향
                    case 'D' -> {
                        if(dq.isEmpty()) {
                            sb.append("error").append("\n");
                            isEnd = false;
                            break;
                        }
                        if(dir) dq.pollFirst();
                        else dq.pollLast() ;
                    }
                }
                if(!isEnd) break;
            }
            if(!isEnd) continue;
            sb.append("[");
            while(!dq.isEmpty()) {
                if (dir) sb.append(dq.pollFirst()).append(",");
                else sb.append(dq.pollLast()).append(",");
            }
            if(sb.charAt(sb.length()-1) == ',') sb.setLength(sb.length()-1);
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}

