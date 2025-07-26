import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] len = new long[n];
        long[] gas = new long[n];

        String[] input = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            long l = Long.parseLong(input[i]);
            len[i] = l;
        }
        for (int i = 0; i < input2.length; i++) {
            long g = Long.parseLong(input2[i]);
            gas[i] = g;
        }

        long answer = 0;
        long minGas = gas[0];

        for (int i = 0; i < n; i++) {
            if (minGas > gas[i])
                minGas = gas[i];

            answer += (minGas * len[i]);
        }

        System.out.println(answer);
    }
}
