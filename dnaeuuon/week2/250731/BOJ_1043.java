import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1043 {
    static int[] parent;

    static int findParent(int a) {
        if (parent[a] != a)
            parent[a] = findParent(parent[a]);

        return parent[a];
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        String[] str = br.readLine().split(" ");
        int trueCnt = Integer.parseInt(str[0]);
        for (int i = 1; i <= trueCnt; i++) {
            int num = Integer.parseInt(str[i]);
            parent[num] = 0;
        }

        ArrayList<Integer>[] arr = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int cnt = Integer.parseInt(input[0]);

            boolean check = false;
            for (int j = 1; j <= cnt; j++) {
                int num = Integer.parseInt(input[j]);
                arr[i].add(num);
            }

            for (int j = 0; j < arr[i].size() - 1; j++) {
                unionParent(arr[i].get(j), arr[i].get(j + 1));
            }
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean check = false;
            for (int j = 0; j < arr[i].size(); j++) {
                int next = arr[i].get(j);
                if (findParent(next) == 0)
                    check = true;
            }
            if (!check)
                result++;
        }

        System.out.println(result);
    }
}
