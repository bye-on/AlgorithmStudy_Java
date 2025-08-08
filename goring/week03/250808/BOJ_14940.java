package week03;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_14940 {
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		int[][] result = new int[N][M];
		for(int[] a : result) {
			Arrays.fill(a, -1);
		}
		
		Point p = null;
		int x;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				x = Integer.parseInt(st.nextToken());
				if(x==1) {
					map[i][j] = true;
				}
				else if(x==0) {
					result[i][j] = 0;
				}
				else if(x==2) {
					map[i][j] = true;
					result[i][j] = 0;
					p = new Point(i, j);
				}
			}
		}
		
		Deque<Point> list = new ArrayDeque<Point>();
		list.add(p);
		
		while(!list.isEmpty()) {
			p = list.pollFirst();
			
			for(int i=0; i<4; i++) { // 상하좌우 탐색
				// 만약 다음에 올 애가 배열 안쪽이고, result에 값이 없으면(방문x)
				if(inArray(p.x+dx[i], p.y+dy[i]) && result[p.x+dx[i]][p.y+dy[i]] == -1) {
					
					// 본인이 지금 1인지 (true)
					if(map[p.x][p.y]) {
						result[p.x+dx[i]][p.y+dy[i]] = result[p.x][p.y] + 1;
						list.add(new Point(p.x+dx[i], p.y+dy[i]));
					}
					else {
						result[p.x+dx[i]][p.y+dy[i]] = 0;
					}
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	public static boolean inArray(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<M) return true;
		else return false;
	}
}
