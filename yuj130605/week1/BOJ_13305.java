package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 거리
        long[] distance = new long[N - 1];
        String[] distanceInput = br.readLine().split(" ");
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(distanceInput[i]);
        }

        // 리터당 가격
        int[] price = new int[N];
        String[] priceInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(priceInput[i]);
        }

        for (int i = 0; i < N - 1; i++) {
            if (price[i] < price[i + 1]) {
                price[i + 1] = price[i];
            }
        }

        long charge = 0;
        for (int i = 0; i < N - 1; i++) {
            charge += price[i] * distance[i];
        }

        System.out.println(charge);
    }
}
