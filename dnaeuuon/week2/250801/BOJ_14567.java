import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            graph[A].add(B);
            indegree[B]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int[] result = new int[N + 1];
        while (!q.isEmpty()) {
            int curret = q.poll();
            if (result[curret] == 0)
                result[curret]++;

            for (int i = 0; i < graph[curret].size(); i++) {
                int next = graph[curret].get(i);
                indegree[next]--;
                result[next] = result[curret] + 1;

                if (indegree[next] == 0)
                    q.add(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}