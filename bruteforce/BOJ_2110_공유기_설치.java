package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

<<<<<<< HEAD
import java.util.Arrays;

public class BOJ_2110_°øÀ¯±â_¼³Ä¡ {

	public static int[] house;

	public static void main(String[] args) throws IOException {

=======
public class BOJ_2110_ê³µìœ ê¸°_ì„¤ì¹˜ {
	static int[] target, src;
	static int T, line, count, max = Integer.MIN_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
>>>>>>> 4da1af844a51d21a8da19d9576fb8da18dbb8c80
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		house = new int[N];

		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);	// ÀÌºÐÅ½»öÀ» ÇÏ±â À§ÇØ¼± ¹Ýµå½Ã Á¤·Ä µÇ¾îÀÖ¾î¾ß ÇÑ´Ù.


		int lo = 1;		// ÃÖ¼Ò °Å¸®°¡ °¡Áú ¼ö ÀÖ´Â ÃÖ¼Ú°ª
		int hi = house[N - 1] - house[0] + 1;	// ÃÖ¼Ò °Å¸®°¡ °¡Áú ¼ö ÀÖ´Â ÃÖ´ñ°ª

		while(lo < hi) {	// Upper Bound Çü½Ä

			int mid = (hi + lo) / 2;

			/*
			 * mid °Å¸®¿¡ ´ëÇØ ¼³Ä¡ °¡´ÉÇÑ °øÀ¯±â °³¼ö°¡ M °³¼ö¿¡ ¸ø¹ÌÄ¡¸é
			 * °Å¸®¸¦ Á¼Çô¾ß ÇÏ±â ¶§¹®¿¡ hi ¸¦ ÁÙÀÎ´Ù.
			 */
			if(canInstall(mid) < M) {
				hi = mid;
			}
			else {
				/**
				 * ¼³Ä¡ °¡´ÉÇÑ °øÀ¯±â °³¼ö°¡ M °³¼öº¸´Ù Å©°Å³ª °°À¸¸é
				 * °Å¸®¸¦ ¹ú¸®¸é¼­ ÃÖ¼Ò°Å¸®°¡ °¡Áú ¼ö ÀÖ´Â ÃÖ´ë °Å¸®¸¦
				 * Ã£¾Æ³½´Ù.
				 */
				lo = mid + 1;
			}
		}

		/*
		 *  Upper Bound´Â Å½»ö °ªÀ» ÃÊ°úÇÏ´Â Ã¹ ¹øÂ° °ªÀ» °¡¸®Å°¹Ç·Î,
		 *  1À» »©ÁØ °ªÀÌ Á¶°Ç½ÄÀ» ¸¸Á·ÇÏ´Â ÃÖ´ñ°ªÀÌ µÈ´Ù.
		 */
		System.out.println(lo - 1);
	}

	// distance¿¡ ´ëÇØ ¼³Ä¡ °¡´ÉÇÑ °øÀ¯±â °³¼ö¸¦ Ã£´Â ¸Þ¼Òµå
	public static int canInstall(int distance) {

		// Ã¹ ¹øÂ° ÁýÀº ¹«Á¶°Ç ¼³Ä¡ÇÑ´Ù°í °¡Á¤
		int count = 1;
		int lastLocate = house[0];

		for(int i = 1; i < house.length; i++) {
			int locate = house[i];

			/*
			 *  ÇöÀç Å½»öÇÏ´Â ÁýÀÇ À§Ä¡¿Í Á÷Àü¿¡ ¼³Ä¡Çß´ø ÁýÀÇ À§Ä¡°£ °Å¸®°¡
			 *  ÃÖ¼Ò °Å¸®(distance)º¸´Ù Å©°Å³ª °°À» ¶§ °øÀ¯±â ¼³Ä¡ °³¼ö¸¦ ´Ã·ÁÁÖ°í
			 *  ¸¶Áö¸· ¼³Ä¡ À§Ä¡¸¦ °»½ÅÇØÁØ´Ù.
			 */
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;

	}


}