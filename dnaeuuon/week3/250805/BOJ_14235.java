import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int cnt = Integer.parseInt(input[0]);
            if (cnt == 0) {
                if (pq.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(-pq.poll()).append("\n");
            } else {
                for (int j = 1; j <= cnt; j++) {
                    int num = Integer.parseInt(input[j]);
                    pq.add(-num);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
