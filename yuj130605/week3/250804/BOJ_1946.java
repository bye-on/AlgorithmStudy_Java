import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            // 입력
            int[][] ranks = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                ranks[i][0] = Integer.parseInt(st.nextToken());
                ranks[i][1] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(ranks, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int cnt = 1;
            int current = ranks[0][1];
            for (int i = 1; i < N; i++) {
                if (ranks[i][1] < current) {
                    current = ranks[i][1];
                    cnt++;
                }
            }

            System.out.println(cnt);

        }
    }
}
