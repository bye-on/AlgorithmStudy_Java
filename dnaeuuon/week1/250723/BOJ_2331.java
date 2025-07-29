import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BOJ_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int P = Integer.parseInt(str[1]);

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        int cnt = 0;
        map.put(A, cnt++);
        arr.add(A);

        while (true) {
            int tmp = 0;
            String input = arr.get(arr.size() - 1).toString();
            for (int i = 0; i < input.length(); i++) {
                int n = input.charAt(i) - '0';
                tmp += Math.pow(n, P);
            }

            if (map.containsKey(tmp)) {
                System.out.println(map.get(tmp));
                break;
            } else {
                arr.add(tmp);
                map.put(tmp, cnt++);
            }
        }
    }
}
