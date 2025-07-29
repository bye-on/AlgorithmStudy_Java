package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            List<Integer> check = new LinkedList<>();

            // 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                q.add(new int[] { tmp, i });
                check.add(tmp);
            }

            // 정렬
            Collections.sort(check);
            Collections.reverse(check);

            int seq = 0;
            int cnt = 0;
            while (!q.isEmpty()) {
                if (q.peek()[0] == check.get(seq)) {
                    if (q.peek()[1] == M) {
                        cnt++;
                        break;
                    }
                    q.poll();
                    seq++;
                    cnt++;
                } else {
                    int[] tmp = q.poll();
                    q.add(tmp);
                }
            }

            System.out.println(cnt);
        }
    }
}