package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
<<<<<<< HEAD

import java.util.Arrays;

public class BOJ_2110_공유기_설치 {

	public static int[] house;

	public static void main(String[] args) throws IOException {

=======
import java.util.Arrays;

public class BOJ_2110_공유기_설치 {
	static int[] target, src;
	static int T, line, count, max = Integer.MIN_VALUE;
	static boolean[] visited;
	static int[] house;
	public static void main(String[] args) throws IOException{
>>>>>>> f4b47cb8f01b16a05017261117bb75ce8f19d74c
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		house = new int[N];

		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

<<<<<<< HEAD
		Arrays.sort(house);    // 이분탐색을 하기 위해선 반드시 정렬 되어있어야 한다.


		int lo = 1;        // 최소 거리가 가질 수 있는 최솟값
		int hi = house[N - 1] - house[0] + 1;    // 최소 거리가 가질 수 있는 최댓값

		while (lo < hi) {    // Upper Bound 형식
=======
		Arrays.sort(house);	// �̺�Ž���� �ϱ� ���ؼ� �ݵ�� ���� �Ǿ��־�� �Ѵ�.


		int lo = 1;		// �ּ� �Ÿ��� ���� �� �ִ� �ּڰ�
		int hi = house[N - 1] - house[0] + 1;	// �ּ� �Ÿ��� ���� �� �ִ� �ִ�

		while(lo < hi) {	// Upper Bound ����
>>>>>>> f4b47cb8f01b16a05017261117bb75ce8f19d74c

			int mid = (hi + lo) / 2;

			/*
<<<<<<< HEAD
			 * mid 거리에 대해 설치 가능한 공유기 개수가 M 개수에 못미치면
			 * 거리를 좁혀야 하기 때문에 hi 를 줄인다.
=======
			 * mid �Ÿ��� ���� ��ġ ������ ������ ������ M ������ ����ġ��
			 * �Ÿ��� ������ �ϱ� ������ hi �� ���δ�.
>>>>>>> f4b47cb8f01b16a05017261117bb75ce8f19d74c
			 */
			if (canInstall(mid) < M) {
				hi = mid;
			} else {
				/**
<<<<<<< HEAD
				 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
				 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
				 * 찾아낸다.
=======
				 * ��ġ ������ ������ ������ M �������� ũ�ų� ������
				 * �Ÿ��� �����鼭 �ּҰŸ��� ���� �� �ִ� �ִ� �Ÿ���
				 * ã�Ƴ���.
>>>>>>> f4b47cb8f01b16a05017261117bb75ce8f19d74c
				 */
				lo = mid + 1;
			}
		}

		/*
<<<<<<< HEAD
		 *  Upper Bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로,
		 *  1을 빼준 값이 조건식을 만족하는 최댓값이 된다.
=======
		 *  Upper Bound�� Ž�� ���� �ʰ��ϴ� ù ��° ���� ����Ű�Ƿ�,
		 *  1�� ���� ���� ���ǽ��� �����ϴ� �ִ��� �ȴ�.
>>>>>>> f4b47cb8f01b16a05017261117bb75ce8f19d74c
		 */
		System.out.println(lo - 1);
	}

<<<<<<< HEAD
	// distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
	public static int canInstall(int distance) {

		// 첫 번째 집은 무조건 설치한다고 가정
=======
	// distance�� ���� ��ġ ������ ������ ������ ã�� �޼ҵ�
	public static int canInstall(int distance) {

		// ù ��° ���� ������ ��ġ�Ѵٰ� ����
>>>>>>> f4b47cb8f01b16a05017261117bb75ce8f19d74c
		int count = 1;
		int lastLocate = house[0];

		for (int i = 1; i < house.length; i++) {
			int locate = house[i];

			/*
<<<<<<< HEAD
			 *  현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
			 *  최소 거리(distance)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
			 *  마지막 설치 위치를 갱신해준다.
=======
			 *  ���� Ž���ϴ� ���� ��ġ�� ������ ��ġ�ߴ� ���� ��ġ�� �Ÿ���
			 *  �ּ� �Ÿ�(distance)���� ũ�ų� ���� �� ������ ��ġ ������ �÷��ְ�
			 *  ������ ��ġ ��ġ�� �������ش�.
>>>>>>> f4b47cb8f01b16a05017261117bb75ce8f19d74c
			 */
			if (locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;

	}

}
