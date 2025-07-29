import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] distance = new long[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N-1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		
		int[] gasStation = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			gasStation[i] = Integer.parseInt(st.nextToken());
		}
		
		int minPrice = Integer.MAX_VALUE;
		long result = 0;
		for (int i=0; i<N-1; i++) {
			if (minPrice > gasStation[i]) {
				minPrice = gasStation[i];
			}
			
			result += minPrice * distance[i];
		}
		
		System.out.println(result);
	}
}

