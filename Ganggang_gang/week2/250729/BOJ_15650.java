import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static int n, m;
    static int[] path;
    static StringBuilder sb = new StringBuilder();

    static void backtrack(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i <= n; i++) {
            path[depth] = i;
            backtrack(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        path = new int[m];

        backtrack(1, 0);
        System.out.print(sb);
    }
}