import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(pq.isEmpty())
					sb.append(0).append("\n");
				else 
					sb.append(pq.poll()).append("\n");
			}
			else {
				pq.add(input);
			}
		}
		
		System.out.println(sb.toString());
	}
}
