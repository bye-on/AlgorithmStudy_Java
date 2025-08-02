import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_18352 {
    static int[] d;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        d[x] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            visited[current] = true;

            for (int i = 0; i < graph[current].size(); i++) {
                int next = graph[current].get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;

                    d[next] = Math.min(d[next], (d[current] + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);
        int X = Integer.parseInt(str[3]);

        d = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].add(b);
        }

        visited = new boolean[N + 1];
        bfs(X);
        for (int i = 1; i <= N; i++) {
            if (d[i] == K)
                sb.append(i).append("\n");
        }

        if (sb.length() == 0)
            System.out.println(-1);
        else
            System.out.println(sb.toString());
    }
}
