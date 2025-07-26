import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int num = 1;
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());

			if(stack.isEmpty() || stack.peek() < input) {
				for(; num <= input; num++) {
					stack.push(num);
					sb.append('+');
				}
				stack.pop();
				sb.append('-');
			}
			else if(stack.peek() == input) {
				stack.pop();
				sb.append('-');
			}
			else {
				System.out.print(-1);
				return;
			}
		}
		
		String[] str = sb.toString().split("");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}
