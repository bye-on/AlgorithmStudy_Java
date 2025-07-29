import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int num = 1;
        int cnt = 1;
        int direction = 0;

        int x = n / 2;
        int y = n / 2;
        map[x][y] = num++;

        while (num <= n * n) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < cnt; j++) {
                    x += dx[direction];
                    y += dy[direction];

                    if (x < 0 || x >= n || y < 0 || y >= n)
                        continue;

                    map[x][y] = num++;
                }
                direction = (direction + 1) % 4;
            }
            cnt++;
        }

        int tx = 1;
        int ty = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");

                if (map[i][j] == target) {
                    tx += i;
                    ty += j;
                }
            }
            sb.append("\n");
        }
        sb.append(tx).append(" ").append(ty);
        System.out.println(sb.toString());
    }
}