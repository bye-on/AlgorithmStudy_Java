import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15649 {
    public static StringBuilder sb = new StringBuilder();

    public static void permutation(int[] perm, boolean[] check, int[] arr, int n, int r, int index, int depth) {
        if (r == 0) {
            for (int i = 0; i < perm.length; i++) {
                sb.append(perm[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (depth >= n)
            return;

        for (int i = 0; i < arr.length; i++) {
            if (!check[arr[i]]) {
                perm[index] = arr[i];
                check[arr[i]] = true;
                permutation(perm, check, arr, n, r - 1, index + 1, depth + 1);
                check[arr[i]] = false;
            }
        }
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
        int[] perm = new int[M];
        permutation(perm, check, arr, N, M, 0, 0);

        System.out.println(sb.toString());
    }
}