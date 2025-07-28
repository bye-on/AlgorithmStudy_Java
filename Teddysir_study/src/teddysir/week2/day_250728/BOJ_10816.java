package teddysir.week2.day_250728;

import java.io.*;
import java.util.*;

public class BOJ_10816 {
	static int N, M;
	static int[] card_list;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		card_list = new int[N];
		for (int i = 0; i < N; i++) {
			card_list[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card_list);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			int back_idx = solution_back(temp);
			int front_idx = solution_front(temp);

			if (front_idx != -1 && back_idx != -1) {
				sb.append(back_idx - front_idx + 1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);

	}

	static int solution_back(int num) {
		int card_idx = -1;

		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int middle = (left + right) / 2;

			if (num >= card_list[middle]) {
				if (num == card_list[middle]) {
					left = middle + 1;
					card_idx = middle;
				} else {
					left = middle + 1;
				}
			} else {
				right = middle - 1;
			}
		}

		return card_idx;
	}

	static int solution_front(int num) {
		int card_idx = -1;

		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int middle = (left + right) / 2;

			if (num <= card_list[middle]) {
				if (num == card_list[middle]) {
					right = middle - 1;
					card_idx = middle;
				} else {
					right = middle - 1;
				}
			} else {
				left = middle + 1;
			}
		}

		return card_idx;
	}

}
