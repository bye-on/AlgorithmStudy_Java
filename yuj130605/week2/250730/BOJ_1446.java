import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 지름길 개수
        int D = Integer.parseInt(input[1]); // 고속도로 길이

        int[] distance = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            distance[i] = i;
        }

        int[][] shortD = new int[N][3];

        for (int i = 0; i < N; i++) {

            input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                shortD[i][j] = Integer.parseInt(input[j]);
            }
        }
        // ------------------------------------------------------------------

        // Arrays.sort(shortD, (o1, o2) -> {
        // return o1[0] - o2[0];
        // });

        for (int i = 1; i <= D; i++) {
            // System.out.println("i=" + i);
            distance[i] = Math.min(distance[i], distance[i - 1] + 1);
            for (int j = 0; j < N; j++) {
                if (shortD[j][1] == i) {
                    // System.out.println("j=" + j);
                    // System.out.println("shortD[j][0]=" + shortD[j][0]);
                    // System.out.println("shortD[j][2]=" + shortD[j][2]);
                    distance[i] = Math.min(distance[i], distance[shortD[j][0]] + shortD[j][2]);
                }
            }
        }

        System.out.println(distance[D]);
    }
}