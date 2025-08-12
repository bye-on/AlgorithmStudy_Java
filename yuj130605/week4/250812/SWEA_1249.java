import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA_1249 {
    static int[][] grid, result;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            // 입력
            grid = new int[N][N];
            result = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    grid[i][j] = line.charAt(j) - '0';
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
            result[0][0] = 0;

            fix();
            System.out.printf("#%d %d\n", test_case, result[N - 1][N - 1]);
        }
    }

    static void fix() {
        int[] dr = { -1, 1, 0, 0 }; // 상하좌우
        int[] dc = { 0, 0, -1, 1 };

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        pq.add(new int[] { 0, 0, grid[0][0] });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int value = current[2];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (result[nr][nc] > value + grid[nr][nc]) {
                        pq.add(new int[] { nr, nc, value + grid[nr][nc] });
                        result[nr][nc] = value + grid[nr][nc];
                    }
                }
            }
        }
    }
}