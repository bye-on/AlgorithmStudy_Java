package forStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15787 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] train = new int[N];
		
		int command, index, who;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			command = Integer.parseInt(st.nextToken());
			index = Integer.parseInt(st.nextToken())-1;
			
			if(command==1) {
				who = Integer.parseInt(st.nextToken());
				train[index] |= 1<<who;
			}
			else if(command==2) {
				who = Integer.parseInt(st.nextToken());
				train[index] &= ~(1<<who);
			}
			else if(command==3) {
				train[index] = (train[index]) << 1;
				train[index] &= ((1 << 21) - 1);
			}
			else if(command==4) {
				train[index] = (train[index]) >> 1;
				train[index] &= ~1;
			}
		}
		
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			if(!list.contains(train[i])) {
				list.add(train[i]);
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	
}
