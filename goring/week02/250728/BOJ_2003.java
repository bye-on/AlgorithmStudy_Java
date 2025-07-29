package forStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = arr[start];
		int answer = 0;
		while(start<N) {
			if(sum<=M && end==N) break;
			
			if(sum == M) {
				answer++;
				sum -= arr[start];
				start++;
				sum += arr[++end];
			}
			else if(sum < M || start==end) {
				sum += arr[++end];
			}
			else if(sum > M) {
				sum -= arr[start];
				start++;
			}
		}
		
		System.out.println(answer);
	}
}
