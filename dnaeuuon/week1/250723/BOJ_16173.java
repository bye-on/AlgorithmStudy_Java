import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16173 {
    public static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static int n;
    static int[] dx = { 0, 1 };
    static int[] dy = { 1, 0 };
    static Pair<Integer, Integer> p = new Pair<Integer, Integer>(-1, -1);

    public static void dfs(int[][] map, int x, int y) {
        if (x == n - 1 && y == n - 1) {
            p.first = x;
            p.second = y;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + (dx[i] * map[x][y]);
            int ny = y + (dy[i] * map[x][y]);

            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;

            if (map[nx][ny] == 0)
                continue;

            dfs(map, nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                int input = Integer.parseInt(str[j]);
                map[i][j] = input;
            }
        }

        dfs(map, 0, 0);
        if (p.first == n - 1 && p.second == n - 1)
            System.out.println("HaruHaru");
        else
            System.out.println("Hing");
    }
}
