package goring;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1913 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int x = N/2;
		int y = N/2;
		map[x][y] = 1;
		int level = 1;
		int now = 2;
		Point answer = new Point(x+1, y+1);
		while(level < N) {
			//위
			for(int i=1; i<=level; i++) {
				map[--x][y] = now;
				if(now==target) answer = new Point(x+1, y+1);
				now++;
			}
			//오른족
			for(int i=1; i<=level; i++) {
				map[x][++y] = now;
				if(now==target) answer = new Point(x+1, y+1);
				now++;
			}
			level++;
			//아래
			for(int i=1; i<=level; i++) {
				map[++x][y] = now;
				if(now==target) answer = new Point(x+1, y+1);
				now++;
			}
			//왼쪽
			for(int i=1; i<=level; i++) {
				map[x][--y] = now;
				if(now==target) answer = new Point(x+1, y+1);
				now++;
			}
			level++;
		}
		//위
		for(int i=1; i<level; i++) {
			map[--x][y] = now;
			if(now==target) answer = new Point(x+1, y+1);
			now++;
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.append(answer.x).append(" ").append(answer.y));
	}
}
