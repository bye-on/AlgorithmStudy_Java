import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_4949 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		char c;
		while ((s = br.readLine()) != null ) {
			if (s.equals(".")) break;
			boolean check = false;
			Stack<Character> stackStr = new Stack<>();
			char[] Line = s.toCharArray();

			for (int i = 0; i < Line.length; i++) {
				if (Line[i] == '(' || Line[i] == '[') {
					stackStr.push(Line[i]);
				}
				if (Line[i] == ')' || Line[i] == ']') {
					if (stackStr.empty()) {
						check = true;
						System.out.println("no");
						break;
					}
					c = stackStr.pop();
					if (c == '(' && Line[i] != ')') {
						check = true;
						System.out.println("no");
						break;
					} else if (c == '[' && Line[i] != ']') {
						check = true;
						System.out.println("no");
						break;
					}
				}
			}

			if (!check) {
				if (stackStr.isEmpty()) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}
	}
}
