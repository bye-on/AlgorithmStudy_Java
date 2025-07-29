import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] len = new int[n-1];
		long [] cost = new long[n];
		int pos = 0;
		long ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<n-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer st_1 = new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			cost[i] = Integer.parseInt(st_1.nextToken());
		}
		
		while(pos < n-1) {
			for(int i = pos+1; i < n; i++) {
				if (cost[pos] > cost[i] || i == n-1 ) {
					for(int j = pos; j< i ; j++ ) {
						ans += cost[pos] * len[j];
						}
					pos = i;
					break;
				}
			}
		}
		
		System.out.print(ans);

	}

}
