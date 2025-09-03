import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    public static int N;
    public static int M;
    public static int[][] graph;
    public static int[][] distance;
    public static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            graph = new int[N+1][N+1];
            result = 0;

            for (int i=0; i<N+1; i++) {
                for (int j=0; j<N+1; j++) {
                    graph[i][j] = 99999;
                }
            }

            for (int i=0; i<M; i++) {
                String[] split = br.readLine().split(" ");
                int a = Integer.parseInt(split[0]), b = Integer.parseInt(split[1]);
                graph[a][b] = 1;
                graph[b][a] = -1;
            }

            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    for (int k=1; k<=N; k++) {
                        if (graph[i][k]+graph[k][j] == 2) graph[i][j] = 1;
                        if (graph[i][k]+graph[k][j] == -2) graph[i][j] = -1;
                    }
                }
            }

            for (int i=1; i<=N; i++) {
                int count = 0;
                for (int j=1; j<=N; j++) {
                    if (graph[i][j] == 1 || graph[i][j] == -1) count++;
                }

                if (count == N-1) {
                    result++;
                }
            }

            sb.append("#").append(t+1).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static void backtrack(int[][] graph, int[] v, boolean[][] visited, boolean canDig, int depth) {

    }
}
