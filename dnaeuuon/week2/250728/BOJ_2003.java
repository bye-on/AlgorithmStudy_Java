import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(input[i]);
            arr[i + 1] += arr[i];
        }

        int s = 0;
        int e = 0;
        int cnt = 0;
        while (s <= N && e <= N) {
            int num = arr[e] - arr[s];
            if (num < M)
                e++;
            else if (num > M)
                s++;
            else {
                s++;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
