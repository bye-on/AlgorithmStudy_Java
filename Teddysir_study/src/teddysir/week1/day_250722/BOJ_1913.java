package teddysir.week1.day_250722;

import java.io.*;
import java.util.*;

public class BOJ_1913 {

	static int N, K, count, limit, time;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // 배열 size x size
		K = Integer.parseInt(br.readLine()); // 찾는 수

		arr = new int[N][N];

		count = N * N;
		time = 0;

		int x = 0;
		int y = 0;
		limit = N;
		while (count > 0) {
			x = time;
			down(x, y);

			y = limit - 1;
			right(x, y);

			x = limit - 1;
			up(x, y);

			y = time;
			left(x, y);
			time++;
			limit--;
			y = time;
		}
		
		StringBuilder sb2 = new StringBuilder();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == K) {
					sb2.append(i+1).append(" ").append(j+1);
				}
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		System.out.println(sb2);
	}

	static void down(int x, int y) {
		for (int i = y; i < limit; i++) {
			arr[i][x] = count--;
		}
	}

	static void right(int x, int y) {
		for (int i = x + 1; i < limit; i++) {
			arr[y][i] = count--;
		}
	}

	static void up(int x, int y) {
		for (int i = y - 1; i >= time; i--) {
			arr[i][x] = count--;
		}
	}

	static void left(int x, int y) {
		for (int i = x - 1; i > time; i--) {
			arr[y][i] = count--;
		}
	}

}

// https://loosie.tistory.com/538 사이트를 참고하고 풀었습니다.
// down, right, up, left 메서드를 만들고 어떤식으로 바깥부터 안ㅇ까지 채워야할지 로직을 생각하는
// 부분에서 while문 안 내용을 생각하는데 시간이 오래걸렸네요
