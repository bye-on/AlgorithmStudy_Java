import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[][] arr = new int[N][N];

        int[][] direction = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        int num = N * N;
        int r = 0, c = 0, dir = 0;

        while (num > 0) {
            arr[r][c] = num;
            if (num == 1) break;
            num--;

            int dr = direction[dir][0];
            int dc = direction[dir][1];

            while (!isValid(r + dr, c + dc, N) || arr[r + dr][c + dc] != 0) {
                dir = (dir + 1) % 4;
                dr = direction[dir][0];
                dc = direction[dir][1];
            }

            r += dr;
            c += dc;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == Q) {
                    System.out.println((i + 1) + " " + (j + 1));
                }
            }
        }

        sc.close();
    }

    public static boolean isValid(int r, int c, int N) {
        return (0 <= r && r < N) && (0 <= c && c < N);
    }
}

