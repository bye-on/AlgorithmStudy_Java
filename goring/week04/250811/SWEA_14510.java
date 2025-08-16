package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14510 {
	static int one, two;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			int maxT = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxT = Math.max(maxT, tree[i]);
			}
			
			int one = 0;
			int two = 0;
			int answer = 0;
			for(int i=0; i<N; i++) {
				two += (maxT-tree[i])/2;
				one += (maxT-tree[i])%2;
			}
			
			while(one+1 < two) {
				two--;
				one += 2;
			}
			
			if(one > two) {
				answer = one+two+(one-two)-1;
			}
			else if(two > one) {
				answer = one+two+(two-one);
			}
			else {
				answer = one+two;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
}
