import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1717 {
    static int[] parent;
    
    static int findParent(int a) {
        if(parent[a] != a) 
            parent[a] = findParent(parent[a]);

        return parent[a];
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int calc = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if(calc == 0) {
                unionParent(a, b);
            } else if (calc == 1) {
                if(findParent(a) != findParent(b))
                    sb.append("NO").append("\n");
                else
                    sb.append("YES").append("\n");
            }
        }
        System.out.println(sb.toString());
    }    
}
