package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int turn = 0;
        while (!queue.isEmpty()) {
            turn++;
            int tmp = queue.poll();

            if (turn % M != 0) {
                queue.add(tmp);
            } else if (turn % M == 0 && !queue.isEmpty()) {
                sb.append(tmp + ", ");
            } else if (turn % M == 0 && queue.isEmpty()) {
                sb.append(tmp + ">");
            }
        }

        System.out.println(sb);
    }
}
