import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int A = 0;
        int B = 0;

        int hourA = 0;
        int minuteA = 0;
        int hourB = 0;
        int minuteB = 0;

        boolean winA = false;
        boolean winB = false;

        int[][] map = new int[2][2]; // 중간 저장 배열
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);

            String[] time = input[1].split(":");
            int hour = Integer.parseInt(time[0]);
            int minite = Integer.parseInt(time[1]);

            if (num == 1)
                A++;
            if (num == 2)
                B++;

            if (A > B) {
                if (!winA) {
                    winA = true;
                    map[0][0] = hour;
                    map[0][1] = minite;
                }
            } else if (A < B) {
                if (!winB) {
                    winB = true;
                    map[1][0] = hour;
                    map[1][1] = minite;
                }
            } else {
                if (winA) {
                    winA = false;

                    int h = hour - map[0][0];
                    int m = minite - map[0][1];

                    if (m < 0) {
                        hourA += (h - 1);
                        minuteA += (60 + m);
                    } else {
                        hourA += h;
                        minuteA += m;
                    }
                }
                if (winB) {
                    winB = false;

                    int h = hour - map[1][0];
                    int m = minite - map[1][1];

                    if (m < 0) {
                        hourB += (h - 1);
                        minuteB += (60 + m);
                    } else {
                        hourB += h;
                        minuteB += m;
                    }
                }
            }
        }

        if (winA) {
            winA = false;
            int hour = 48 - map[0][0];
            int minute = map[0][1];

            if (minute >= 0) {
                minuteA += (60 - minute);
                hourA += (hour - 1);
            } else {
                hourA += hour;
                minuteA += minute;
            }
        }
        if (winB) {
            winB = false;
            int hour = 48 - map[1][0];
            int minute = map[1][1];

            if (minute >= 0) {
                minuteB += (60 - minute);
                hourB += (hour - 1);
            } else {
                hourB += hour;
                minuteB += minute;
            }
        }

        hourA += (minuteA / 60);
        minuteA %= 60;

        hourB += (minuteB / 60);
        minuteB %= 60;

        System.out.printf("%02d:%02d", hourA, minuteA);
        System.out.println();
        System.out.printf("%02d:%02d", hourB, minuteB);
    }
}
