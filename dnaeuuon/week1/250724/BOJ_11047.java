import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
        }

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K >= arr[i]) {
                answer += (K / arr[i]);
                K %= arr[i];
            }
        }
        System.out.println(answer);
    }
}
