import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			String[] arr = str.toString().split(" ");

			if(arr[0].equals("push")) {
				int num = Integer.parseInt(arr[1]);
				dq.add(num);
			}
			if(arr[0].equals("pop")) {
				if(dq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(dq.poll()).append("\n");
				}
			}
			if(arr[0].equals("size")) {
				sb.append(dq.size()).append("\n");
			}
			if(arr[0].equals("empty")) {
				if(dq.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			if(arr[0].equals("front")) {
				if(dq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(dq.getFirst()).append("\n");
				}
			}
			if(arr[0].equals("back")) {
				if(dq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(dq.getLast()).append("\n");
				}
			}
		}
		 System.out.println(sb.toString());
	}
}
