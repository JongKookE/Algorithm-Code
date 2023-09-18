package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_2110_공유기_설치 {
	static int[] target, src;
	static int T, line, count, max = Integer.MIN_VALUE;
	static boolean[] visited;
	static int[] house;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		house = new int[N];

		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);	// �̺�Ž���� �ϱ� ���ؼ� �ݵ�� ���� �Ǿ��־�� �Ѵ�.


		int lo = 1;		// �ּ� �Ÿ��� ���� �� �ִ� �ּڰ�
		int hi = house[N - 1] - house[0] + 1;	// �ּ� �Ÿ��� ���� �� �ִ� �ִ�

		while(lo < hi) {	// Upper Bound ����

			int mid = (hi + lo) / 2;

			/*
			 * mid �Ÿ��� ���� ��ġ ������ ������ ������ M ������ ����ġ��
			 * �Ÿ��� ������ �ϱ� ������ hi �� ���δ�.
			 */
			if(canInstall(mid) < M) {
				hi = mid;
			}
			else {
				/**
				 * ��ġ ������ ������ ������ M �������� ũ�ų� ������
				 * �Ÿ��� �����鼭 �ּҰŸ��� ���� �� �ִ� �ִ� �Ÿ���
				 * ã�Ƴ���.
				 */
				lo = mid + 1;
			}
		}

		/*
		 *  Upper Bound�� Ž�� ���� �ʰ��ϴ� ù ��° ���� ����Ű�Ƿ�,
		 *  1�� ���� ���� ���ǽ��� �����ϴ� �ִ��� �ȴ�.
		 */
		System.out.println(lo - 1);
	}

	// distance�� ���� ��ġ ������ ������ ������ ã�� �޼ҵ�
	public static int canInstall(int distance) {

		// ù ��° ���� ������ ��ġ�Ѵٰ� ����
		int count = 1;
		int lastLocate = house[0];

		for(int i = 1; i < house.length; i++) {
			int locate = house[i];

			/*
			 *  ���� Ž���ϴ� ���� ��ġ�� ������ ��ġ�ߴ� ���� ��ġ�� �Ÿ���
			 *  �ּ� �Ÿ�(distance)���� ũ�ų� ���� �� ������ ��ġ ������ �÷��ְ�
			 *  ������ ��ġ ��ġ�� �������ش�.
			 */
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;

	}


}