package goring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1966 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Deque<Integer> file = new ArrayDeque<>();
			int W = 0;
			int max = 0;
			int now;
			for(int i=0; i<N; i++) {
				now = Integer.parseInt(st.nextToken());
				if(i==M) {
					file.addLast(now+100);
				}
				else file.addLast(now);
				max = Math.max(max, now%100);
			}
			
			int i = 1;
			while(!file.isEmpty()) {
				now = file.poll();
				if(now == max+100) break;
				
				if(now == max) {
					i++;
					max = 0;
					for(int a : file) {
						max = Math.max(max, a%100);
					}
					continue;
				}
				file.addLast(now);
			}
			
			bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}


