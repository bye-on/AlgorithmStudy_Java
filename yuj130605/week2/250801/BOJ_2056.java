import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 작업 개수

        int[] time = new int[N];
        int[] table = new int[N];
        List<List<Integer>> after = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            after.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            table[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < table[i]; j++) {
                int prev = Integer.parseInt(st.nextToken());
                after.get(prev - 1).add(i);
            }
        }

        System.out.println(topological(N, time, table, after));
    }

    static int topological(int N, int[] time, int[] table, List<List<Integer>> after) {
        Queue<Integer> queue = new LinkedList<>();
        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {
            sum[i] = time[i];

            if (table[i] == 0) {
                queue.add(i);
            }
        }

        while (!(queue.isEmpty())) {
            int current = queue.poll();

            for (int next : after.get(current)) {
                table[next]--;

                sum[next] = Math.max(sum[next], sum[current] + time[next]);

                if (table[next] == 0) {
                    queue.add(next);
                }
            }
        }

        int result = 0;
        for (int i : sum) {
            result = Math.max(i, result);
        }

        return result;
    }
}
