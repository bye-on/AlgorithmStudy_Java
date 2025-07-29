package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16173 {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String answer = "Hing";
		Deque<Integer> list = new ArrayDeque<>();
		list.add(0);
		list.add(0);
		int nowX, nowY;
		while(!list.isEmpty()) {
			nowX = list.pollFirst();
			nowY = list.pollFirst();
			if(nowX==N-1 && nowY==N-1) {
				answer = "HaruHaru";
				break;
			}
			
			// 오른쪽 이동
			if(inArrays(nowX, nowY+map[nowX][nowY]) && !visited[nowX][nowY+map[nowX][nowY]]) {
				visited[nowX][nowY + map[nowX][nowY]] = true;
				list.addLast(nowX);
				list.addLast(nowY + map[nowX][nowY]);
			}
			// 아래 이동
			if(inArrays(nowX+map[nowX][nowY], nowY) && !visited[nowX+map[nowX][nowY]][nowY])
			{	visited[nowX+map[nowX][nowY]][nowY] = true;
				list.addLast(nowX+map[nowX][nowY]);
				list.addLast(nowY);
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean inArrays(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N) return true;
		else return false;
	}
}
