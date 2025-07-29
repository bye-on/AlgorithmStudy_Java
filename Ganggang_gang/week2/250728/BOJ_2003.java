//2003 번 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int cnt = 0;
        int sum = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            while (end < n && sum < m) {
                sum += arr[end++];
            }
            if (sum == m) {
                cnt++;
            }
            sum -= arr[i];
        }

        System.out.println(cnt);
    }
}
