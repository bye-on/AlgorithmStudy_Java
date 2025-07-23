package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String list = br.readLine();
		Deque<Character> small;
		char now;
		boolean flag;
		
		while(!list.equals(".")) {
			small = new ArrayDeque<>();
			flag = false;
			
			for(int i=0; i<list.length(); i++) {
				if(list.charAt(i) == '(' || list.charAt(i) == '[') {
					small.addLast(list.charAt(i));
				}
				else if(list.charAt(i) == ')') {
					if(!small.isEmpty()) {
						now = small.pollLast();
						if(now != '(') {
							flag = true;
							break;
						}
					}
					else {
						flag = true;
						break;
					}
				}
				else if(list.charAt(i) == ']') {
					if(!small.isEmpty()) {
						now = small.pollLast();
						if(now != '[') {
							flag = true;
							break;
						}
					}
					else {
						flag = true;
						break;
					}
				}
			}
			if(flag || !small.isEmpty()) System.out.println("no");
			else System.out.println("yes");
			list = br.readLine();
		}
	}
}
