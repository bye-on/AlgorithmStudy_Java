package teddysir.week2.day_250728;

import java.io.*;
import java.util.*;

public class BOJ_2805 {

	static long H, max_H;
	static int tree_num, need_tree;
	static int[] trees;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		tree_num = Integer.parseInt(st.nextToken());
		need_tree = Integer.parseInt(st.nextToken());

		trees = new int[tree_num];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < tree_num; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max_H = Math.max(trees[i], max_H);
		}

		solution();
		System.out.println(H);
	}

	static void solution() {
		long left = 0;
		long right = max_H;

		while (left <= right) {
			long middle = (left + right) / 2;

			long tempSum = 0;
			for (int i = 0; i < tree_num; i++) {
				if (trees[i] > middle) {
					tempSum += (trees[i] - middle);
				}
			}

			if (tempSum >= need_tree) {
				H = middle;
				left = middle + 1;
			} else {
				right = middle - 1;
			}

		}

	}

}
