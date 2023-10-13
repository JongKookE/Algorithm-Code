package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	static ArrayList<Integer> als;
	static int T;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		als = new ArrayList<>();
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("empty") || command.equals("all")) {
				operator(command);
				continue;
			}
			int value = Integer.parseInt(st.nextToken());
			operator(command, value);
		}
        System.out.println(sb);

	}
	static void operator(String command, int value) {
		switch(command){
			case "add": 
				if(!als.contains(value)) als.add(value); 
				break;
			case "remove":
				if(als.contains(value)) als.remove(als.indexOf(value));
				break;
			case "check" :
				if(als.contains(value)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "toggle":
				if(als.contains(value)) operator("remove", value);
				else operator("add", value);
				break;
		}		
	}
	static void operator(String command) {
		switch(command) {
			case "all":
				als.clear();
				for(int i = 1; i <= 20; i++) als.add(i);
				break;
			case "empty":
				als.clear();
				break;
		}
	}
}

