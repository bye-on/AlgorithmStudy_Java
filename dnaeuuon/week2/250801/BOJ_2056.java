import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2056 {
    static int[] indgree;
    static int[] cost;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        indgree = new int[N + 1];
        cost = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int c = Integer.parseInt(input[0]);
            cost[i] = c;

            int M = Integer.parseInt(input[1]);
            for (int j = 0; j < M; j++) {
                int next = Integer.parseInt(input[2 + j]);

                indgree[i]++;
                graph[next].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(indgree[i] == 0)
                q.add(i);
        }

        int[] dp = new int[N + 1];
        while (!q.isEmpty()) {
            int current = q.poll();
            dp[current] = Math.max(dp[current], cost[current]);

            for (int i = 0; i < graph[current].size(); i++) {
                int next = graph[current].get(i);
                indgree[next]--;
                dp[next] = Math.max(dp[next], cost[next] + dp[current]);

                if(indgree[next] == 0) 
                    q.add(next);
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(result < dp[i]) 
                result = dp[i];
        }

        System.out.println(result);
    }
}