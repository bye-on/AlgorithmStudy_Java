import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_18352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 도시의 개수
        int M = Integer.parseInt(input[1]); // 도로의 개수
        int K = Integer.parseInt(input[2]); // 거리 정보
        int X = Integer.parseInt(input[3]); // 출발 도시 번호

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 s->f
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int f = Integer.parseInt(input[1]);

            graph.get(s).add(f);
        }

        int[] distance = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            distance[i] = -1;
        }
        distance[X] = 0; // 시작도시

        bfs(X, graph, distance);

        boolean exist = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                exist = true;
            }
        }

        if (!exist) {
            System.out.println(-1);
        }

    }

    static void bfs(int X, List<List<Integer>> graph, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : graph.get(current)) {
                if (distance[i] == -1) {
                    distance[i] = distance[current] + 1;
                    queue.add(i);
                }
            }
        }
    }
}