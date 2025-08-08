import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        int result = 0;
        for (int i = 1; i <= N; i++) {
            q.add(i);
            while (!q.isEmpty()) {
                int current = q.poll();
                if (!visited[current])
                    result++;

                visited[current] = true;
                for (int j = 0; j < graph[current].size(); j++) {
                    int next = graph[current].get(j);
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
