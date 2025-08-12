package week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// 랜선 값 초기화 및 max값 설정을 위한 계산식
		long[] arr = new long[K];
		long max = 0;
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max += arr[i];
		}
		
		// 낭비가 하나도 없는 경우
		max = max/N;
		
		// 모두 낭비 -> 모든 랜선의 길이가 1인 경우
		long min = 1;
		long middle = 0;
		
		int nowN;
		long result = 1;
		while(min <= max) {
			middle = (max + min) / 2;
			// middle 길이로 잘랐을 때 랜선 개수 : nowN
			nowN = 0;
			for(int i=0; i<K; i++) {
				nowN += arr[i]/middle;
			}
			
			// 랜선 개수가 N보다 많음
			if(nowN >= N) {
				// min 갱신, middle 갱신
				min = middle + 1;
				result = middle;
			}
			else if(nowN < N) {
				max = middle - 1;
			}
		}
		
		System.out.print(result);
	}
}

