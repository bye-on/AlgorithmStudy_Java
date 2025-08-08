package week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] node = new int[N][2];
			
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				node[i][0] = Integer.parseInt(st.nextToken());
				node[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(node, (a, b)-> a[0] - b[0]);
			
			int answer = 1;
			int minV = node[0][1];
			for(int i=1; i<N; i++) {
				if(minV > node[i][1]) {
					minV = node[i][1];
					answer++;
				}
			}

			System.out.println(answer);
		}
	}
}
