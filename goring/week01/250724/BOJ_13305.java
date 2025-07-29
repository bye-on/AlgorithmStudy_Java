package forStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] len = new long[N-1];
		long[] node = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			len[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			node[i] = Long.parseLong(st.nextToken());
		}
		// min 기름값 저장
		long priceMin = Integer.MAX_VALUE;
		
		// 0 도시에서 0-1 거리만큼 기름 넣기 (반복)
		long result = 0L;
		for(int i =0; i<N-1; i++) {
			priceMin = Math.min(priceMin, node[i]);
			result += priceMin*len[i];
		}
		
		System.out.println(result);
	}
}
