package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1786_찾기 {
	static int[] pi;
	static int cnt;
	static String T, P;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		
		kmp(T, P);
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void kmp(String text, String pattern) {
		makePi(pattern);
		
		int tLength = text.length();
		int pLength = pattern.length();
		char[] tArray = text.toCharArray();
		char[] pArray = pattern.toCharArray();
		
		int j = 0; 
		for(int i = 0; i < tLength; i++) {
			while(j > 0 && tArray[i] != pArray[j]) j = pi[j-1];
			// 현재 text 의 i 번째 글자와 pattern 의 j 번째 글자가 일치한 상황
			// 모두 일치하거나 부분적으로 일치하거나
			if(tArray[i] == pArray[j]) {
				// 모두 일치
				if (j == pLength - 1) {
					cnt++;
					sb.append(i - j + 1).append(" ");
					j = pi[j];
					
				}
				// 부분 일치
				else {
					j++;
				}
			}
		}
				
	}
	static void makePi(String p) {
		pi = new int[p.length()];
		char[] pArray = p.toCharArray();
		
		// j 가 접두사 쪽 인덱스, i 가 접미사 쪽 인덱스		
		int j = 0;		
		for(int i = 1; i < pArray.length; i++) {
			// i 번째 값(접미사)과 j(접두사) 가 일치하거나, j가 0이면 while 탈출
			while(j > 0 && pArray[i] != pArray[j]) j = pi[j-1];
			if(pArray[i] == pArray[j]) pi[i] = ++j;
		}
	}
}
