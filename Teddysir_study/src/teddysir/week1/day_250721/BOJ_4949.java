package teddysir.week1.day_250721;

import java.io.*;
import java.util.*;

public class BOJ_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String ans = "yes";
			Stack<Character> stack = new Stack<>();

			String input = br.readLine();
			if (input.equals("."))
				break;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '.') {
					continue;
				}

				if (input.charAt(i) == '(') {
					stack.add('(');
				} else if (input.charAt(i) == '[') {
					stack.add('[');
				} else if (input.charAt(i) == ')') {
					if (stack.isEmpty()) {
						ans = "no";
						continue;
					}
					char temp = stack.pop();
					if (temp != '(') {
						ans = "no";
						continue;
					}
				} else if (input.charAt(i) == ']') {
					if (stack.isEmpty()) {
						ans = "no";
						continue;
					}
					char temp = stack.pop();
					if (temp != '[') {
						ans = "no";
						continue;
					}
				}
			}
			if(!stack.isEmpty()) {
				ans = "no";
			}

			sb.append(ans).append("\n");
		}

		System.out.println(sb);

	}

}

// 문제 풀면서 어려웠던점
// 1. EOF 가 제대로 되지 않아서 문제 발생
// 2. 마지막 !stack.isEmpty() -> ans = "no" 라는 부분을 처음에 명시하지 않아 반례 발생 
// 2-2 ex) [[]. 이 나타나도 yes가 출력되었음 하지만 마지막 if문을 추가
