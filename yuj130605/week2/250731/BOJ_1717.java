import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1717 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]); // 연산 개수

        List<List<Integer>> set = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            set.add(new ArrayList<>());
            set.get(i).add(i);
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (d == 0) {
                union(a, b, set);
            } else {
                System.out.println(isExist(a, b, set) ? "YES" : "NO");
            }
        }

    }

    private static boolean isExist(int a, int b, List<List<Integer>> set) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).contains(a) && set.get(i).contains(b)) {
                return true;
            }
        }

        return false;
    }

    static void union(int a, int b, List<List<Integer>> set) {
        for (int i = 0; i < set.size(); i++) {
            for (int j = i + 1; j < set.size(); j++) {
                if ((set.get(i).contains(a) && set.get(j).contains(b))
                        || (set.get(i).contains(b) && set.get(j).contains(a))) {

                    set.get(i).addAll(set.get(j));
                    set.remove(j);
                    return;
                }
            }

        }
    }
}
