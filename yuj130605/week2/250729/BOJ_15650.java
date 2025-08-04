import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }

        List<List<Integer>> results = combine(N, M, arr, new ArrayList<>(), new ArrayList<>(), 0);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> result : results) {
            for (Integer i : result) {
                sb.append(i + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static List<List<Integer>> combine(int N, int M, int[] arr, List<Integer> current, List<List<Integer>> result,
            int begin) {
        if (current.size() == M) {
            result.add(new ArrayList<>(current));
            return result;
        }

        for (int i = begin; i < N; i++) {
            current.add(arr[i]);
            combine(N, M, arr, current, result, i + 1);
            current.remove(current.size() - 1);
        }

        return result;
    }
}
