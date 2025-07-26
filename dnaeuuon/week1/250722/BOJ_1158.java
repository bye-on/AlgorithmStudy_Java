import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        sb.append("<");
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            for (int i = 1; i < k; i++) {
                q.add(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll());
        sb.append(">");
        System.out.println(sb.toString());
    }
}
