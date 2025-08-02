package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
	static int[] list;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		list = new int[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = i;
		}
		
		StringBuilder sb= new StringBuilder();
		int index, input, command;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			command = Integer.parseInt(st.nextToken());
			index = Integer.parseInt(st.nextToken());
			input = Integer.parseInt(st.nextToken());
			
			if(command==0) {
				Union(index, input);
			}
			else if(command==1) {
				sb.append(isSame(index, input) ? "YES" : "NO").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int find(int index) {
		// index가 최상위인 경우
		if(list[index]==index) {
			return index;
		}
		// index가 부모를 가짐, index를 최상위 수로 다 바꿔
		return list[index] = find(list[index]);
	}
	
	public static void Union(int index, int input) {
		// 각각 노드의 최상위 친구를 찾아줌
		index = find(index);
		input = find(input);
		
		if(index==input) return;
		
		list[index] = input;
	}
	
	public static boolean isSame(int index, int input) {
		index = find(index);
		input = find(input);
		
		if(index==input) return true;
		else return false;
	}
}
