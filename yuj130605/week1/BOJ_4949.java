package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            char[] charArr = line.toCharArray();
            if (line.charAt(0) == '.' && line.length() == 1) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isTrue = true;
            for (char ch : charArr) {
                if (ch == '.') {
                    continue;
                }

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || !(stack.pop() == '(')) {
                        isTrue = false;
                        continue;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || !(stack.pop() == '[')) {
                        isTrue = false;
                        continue;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isTrue = false;
            }

            sb.append(isTrue ? "yes\n" : "no\n");
            line = br.readLine();
        }
        System.out.println(sb);
    }
}
