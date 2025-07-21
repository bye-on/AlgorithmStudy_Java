package teddysir.week1.day_250721;

import java.io.*;
import java.util.*;

public class BOJ_1966 {

	static int T, docs, find;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			docs = Integer.parseInt(st.nextToken());
			find = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			Queue<int[]> q = new LinkedList<>();
			for (int j = 0; j < docs; j++) {
				q.add(new int[] { j, Integer.parseInt(st.nextToken()) }); // j 배열순서 / 그리고 입력받은
			}

			int count = 0;

			while (!q.isEmpty()) {
				int[] temp = q.poll();
				boolean checker = false;
				
				for(int[] doc : q) { 
					if(temp[1] < doc[1]) {
						checker = true;
						break; // 스탑  
						
					}
				}

				if(checker) {
					q.add(temp);
				} else{
					count++;
					if(temp[0] == find) {
						break;
					}
				}
				

				
			}
			sb.append(count).append("\n");

		}
		System.out.println(sb);
	}

}
