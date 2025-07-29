package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1913 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] grid = new int[N][N];
        int[] dr = {1, 0, -1, 0};  // 하우상좌
        int[] dc = {0, 1, 0, -1};

        int row = 0, col = 0, dir = 0;
        int num = N * N;

        int targetRow = 0, targetCol = 0;

        while (num > 0) {
            grid[row][col] = num;
            if (num == target) {
                targetRow = row + 1;
                targetCol = col + 1;
            }

            int nr = row + dr[dir];
            int nc = col + dc[dir];

            // 범위를 벗어나면 방향 전환
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || grid[nr][nc] != 0) {
                dir = (dir + 1) % 4;
                nr = row + dr[dir];
                nc = col + dc[dir];
            }

            row = nr;
            col = nc;
            num--;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int[] line : grid) {
            for (int val : line) {
                sb.append(val+" ");
            }
            sb.append("\n");
        }
        sb.append(targetRow+" "+targetCol);
        System.out.println(sb.toString());
    }
}
