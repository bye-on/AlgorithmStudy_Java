import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1446 {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int D = Integer.parseInt(str[1]);

        d = new int[100001];
        for (int i = 0; i < 100000; i++) {
            d[i + 1] = d[i] + 1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            pq.add(new int[] {s, e, cost});
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int s = current[0];
            int e = current[1];
            int cost = current[2];

            d[e] = Math.min(d[s] + cost, d[e]);
            
            for (int i = 0; i <= D; i++) {
                d[i + 1] = Math.min(d[i + 1], d[i] + 1);
            }
        }

        for (int i = 0; i <= D; i++) {
            d[i + 1] = Math.min(d[i + 1], d[i] + 1);
        }
        
        System.out.println(d[D]);
    }
}
