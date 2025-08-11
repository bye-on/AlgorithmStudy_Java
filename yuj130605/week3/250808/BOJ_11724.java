import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static List<List<Integer>> network;
    static int N, M, cnt;
    static boolean[] visited;

    public static void main(String[] args) throws FileNotFoundException, Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 서버의 개수
        M = Integer.parseInt(st.nextToken()); // 네트워크 연결 정보 수

        network = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            network.add(new ArrayList<>());
        }

        // 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network.get(a).add(b);
            network.get(b).add(a);
        }

        visited = new boolean[N + 1];
        cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int current = q.poll();

            if (!visited[current]) {
                visited[current] = true;

                for (int w : network.get(current)) {
                    if (!visited[w]) {
                        q.add(w);
                    }
                }
            }
        }
    }
}
