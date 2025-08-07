import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   
        int M = Integer.parseInt(st.nextToken());   

        int[][] arr = new int[N+1][N+1];
        int[][] ps  = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                ps[i][j] = arr[i][j]
                         + ps[i-1][j]
                         + ps[i][j-1]
                         - ps[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = ps[x2][y2]
                    - ps[x1-1][y2]
                    - ps[x2][y1-1]
                    + ps[x1-1][y1-1];

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
