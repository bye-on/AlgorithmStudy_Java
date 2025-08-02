package teddysir.week2.day_250728;

import java.io.*;
import java.util.*;

public class BOJ_2003 {
	static int N, M, count;
	static int[] arr;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		solution(M);

		System.out.println(count);

	}

	static void solution(int target) {

		int left = 0;
		int right = 1;

		while (right != N + 1) {
			int temp = 0;

			for (int i = left; i < right; i++) {
				temp += arr[i];
			}
			if (temp == target) {
				count++;
				right++;
			} else if (temp > target) {
				left++;
			} else {
				right++;
			}

		}

	}

}
