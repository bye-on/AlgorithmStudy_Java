package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16173 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력
        int[][] grid = new int[N][N];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }

       System.out.println(jump(N, grid, 0, 0, new boolean[N][N])?"HaruHaru":"Hing");

        
    }

    static boolean jump(int N, int[][] grid, int row, int col, boolean[][] visited){
        if (grid[row][col] == -1) {
            return true;
        }

        // 하
        if ((row+grid[row][col] < N) && jump(N, grid, row+grid[row][col], col, visited)) {
            return true;
        }

        // 우
        if ((col+grid[row][col] < N) && jump(N, grid, row, col+grid[row][col], visited)) {
            return true;
        }

        return false;
    }
}
