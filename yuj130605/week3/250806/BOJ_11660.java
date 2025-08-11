import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                // 누적합
                if (j != 0)
                    grid[i][j] = grid[i][j - 1] + grid[i][j];

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int finishX = Integer.parseInt(st.nextToken());
            int finishY = Integer.parseInt(st.nextToken());

            int result = sum(N, grid, startX, startY, finishX, finishY);

            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

    static int sum(int N, int[][] grid, int startX, int startY, int finishX, int finishY) {
        int result = 0;

        for (int x = startX - 1; x <= finishX - 1; x++) {
            if (startY - 2 < 0) {
                result += grid[x][finishY - 1];
            } else {
                result += grid[x][finishY - 1] - grid[x][startY - 2];
            }

        }

        return result;
    }
}
