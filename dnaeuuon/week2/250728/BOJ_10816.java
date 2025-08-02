import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_10816 {
    public static int binary_search(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            int m = (s + e) / 2;

            if (arr[m] < target)
                s = m + 1;
            else if (arr[m] > target)
                e = m - 1;
            else
                return m;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] inputN = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] inputM = br.readLine().split(" ");

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(inputN[i]);

            if (!map.containsKey(input))
                map.put(input, 1);
            else {
                int tmp = map.get(input);
                map.replace(input, ++tmp);
            }
        }
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(inputM[i]);
            if (map.containsKey(target))
                sb.append(map.get(target)).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb.toString());
    }
}
