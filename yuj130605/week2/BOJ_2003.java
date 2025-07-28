import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sum(N, M, arr));

    }

    static int sum(int N, int M, int[] arr) {

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int current = 0;

            for (int j = i; j < N; j++) {
                current += arr[j];
                if (current == M) {
                    cnt++;
                    break;
                } else if (current >= M) {
                    break;
                }
            }
        }

        return cnt;
    }

}