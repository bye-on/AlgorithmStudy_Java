import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15650 {
    public static StringBuilder sb = new StringBuilder();

    public static void combination(int[] comb, boolean[] check, int[] arr, int n, int r, int index, int depth) {
        if (r == 0) {
            for (int i = 0; i < comb.length; i++) {
                sb.append(comb[i] + " ");
            }
            sb.append("\n");
            return;
        }

        if (depth >= n)
            return;
        if (index >= n)
            return;

        comb[depth] = arr[index];

        combination(comb, check, arr, n, r - 1, index + 1, depth + 1);
        combination(comb, check, arr, n, r, index + 1, depth);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        boolean[] check = new boolean[N + 1];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int[] comb = new int[M];
        combination(comb, check, arr, N, M, 0, 0);

        System.out.println(sb.toString());
    }
}
