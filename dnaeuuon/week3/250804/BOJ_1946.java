import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                int A = Integer.parseInt(input[0]);
                int B = Integer.parseInt(input[1]);
                pq.add(new int[] { A, B });
            }

            int b = Integer.MAX_VALUE;
            int result = 0;
            while (!pq.isEmpty()) {
                int[] arr = pq.poll();

                if (b > arr[1]) {
                    b = arr[1];
                    result++;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
