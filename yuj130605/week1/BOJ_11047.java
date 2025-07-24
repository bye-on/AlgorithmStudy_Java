package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int K = Integer.parseInt(line.split(" ")[1]);

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            cnt += K / coin[i];
            K %= coin[i];

            if (K == 0) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
