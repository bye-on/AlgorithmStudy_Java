import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] s = new int[N];
        int[] e = new int[N];
        int[] l = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            e[i] = Integer.parseInt(st.nextToken());
            l[i] = Integer.parseInt(st.nextToken());
        }
        int[] dist = new int[D + 1];
        boolean[] used = new boolean[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i <= D; i++) {
            int u = -1, min = Integer.MAX_VALUE;
            for (int j = 0; j <= D; j++) {
                if (!used[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            if (u == -1) break;
            used[u] = true;
            if (u + 1 <= D && dist[u] + 1 < dist[u + 1]) {
                dist[u + 1] = dist[u] + 1;
            }
            for (int k = 0; k < N; k++) {
                if (s[k] == u && e[k] <= D) {
                    int nd = dist[u] + l[k];
                    if (nd < dist[e[k]]) {
                        dist[e[k]] = nd;
                    }
                }
            }
        }
        System.out.println(dist[D]);
    }
}
