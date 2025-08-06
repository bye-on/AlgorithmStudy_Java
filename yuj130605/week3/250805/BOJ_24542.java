import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24542 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 교육생 수
        int M = Integer.parseInt(st.nextToken()); // 친분 관계의 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for (int i = 0; i <= N; i++) {
            findParent(i);
        }

        int[] cnt = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            cnt[findParent(i)]++;
        }

        long result = 1;
        for (long i : cnt) {
            if (i != 0) {
                result = (result * i) % 1000000007;
            }
        }

        System.out.println(result);

    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a != b) {
            if (a < b)
                parent[b] = a;
            else
                parent[a] = b;
        }
    }

    static int findParent(int a) {
        if (parent[a] == a) {
            return a;
        }

        parent[a] = findParent(parent[a]);
        return parent[a];
    }

}