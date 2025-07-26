import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {
    static StringBuilder sb = new StringBuilder();

    static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i = 0; i < graph[v].size(); i++) {
            int next = graph[v].get(i);
            if (!visited[next])
                dfs(graph, visited, next);
        }
    }

    static void bfs(ArrayList<Integer>[] graph, boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while (!q.isEmpty()) {
            int current = q.poll();
            visited[current] = true;
            sb.append(current).append(" ");

            for (int i = 0; i < graph[current].size(); i++) {
                int next = graph[current].get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int v = Integer.parseInt(str[2]);

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] DFSvisited = new boolean[n + 1];
        dfs(graph, DFSvisited, v);
        sb.append("\n");
        boolean[] BFSvisited = new boolean[n + 1];
        bfs(graph, BFSvisited, v);
        System.out.println(sb.toString());
    }
}
