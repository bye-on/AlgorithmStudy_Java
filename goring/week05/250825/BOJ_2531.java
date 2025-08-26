package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 접시 수
		int N = Integer.parseInt(st.nextToken());
		// 초밥 종류 수
		int d = Integer.parseInt(st.nextToken());
		// 연속 접시 수
		int k = Integer.parseInt(st.nextToken());
		// 쿠폰 번호
		int c = Integer.parseInt(st.nextToken());
		
		// 초밥 리스트
		int[] list = new int[N+k];
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		for(int i=N; i<N+k; i++) {
			list[i] = list[i-N];
		}
		
		
		// 초기값 설정
		int[] visited = new int[d+1];
		int answer = 0;
		for(int i=0; i<k; i++) {
			if(visited[list[i]]==0) {
				answer++;
				visited[list[i]]++;
			}
			else visited[list[i]]++;

		}
		if(visited[c]==0) {
			visited[c]++;
			answer++;
		}
		
		
		// 쿠폰 초밥을 먹는 모든 경우의 수
		int start = 0;
		int end = k;
		int count = answer;
		while(end < N+k) {
			// start 초밥을 빼줌
			visited[list[start]]--;
			if(visited[list[start]]==0)count--;
			
			// end 초밥을 더해줌
			if(visited[list[end]]==0)count++;
			visited[list[end]]++;
			
			if(visited[c]==0) {
				visited[c]++;
				count++;
			}
			
			answer = Math.max(answer, count);
			
			start++;
			end++;
		}
		
		System.out.println(answer);
	}
}

