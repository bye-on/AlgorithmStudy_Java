
import java.io.*;
import java.util.*;

public class BOJ_2852 {

	static int N, team_1, team_2;
	static int team1_min, team2_min, team1_sec, team2_sec;
	static int set_min, set_sec;
	static int count;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tempTeam = Integer.parseInt(st.nextToken());
			String tempTime = st.nextToken();

			checker(tempTeam, tempTime);

		}

		int diffHour = 48 - set_min;
		int diffSec = 0 - set_sec;
		if (diffSec < 0) {
			diffHour -= 1;
			diffSec = 60 + diffSec;
		}

		if (team_1 > team_2) {
			team1_min += diffHour;
			team1_sec += diffSec;
		} else if (team_1 < team_2) {
			team2_min += diffHour;
			team2_sec += diffSec;
		}

		if (team1_sec >= 60) {
			team1_min += team1_sec / 60;
			team1_sec = team1_sec % 60;
		}

		if (team2_sec >= 60) {
			team2_min += team2_sec / 60;
			team2_sec = team2_sec % 60;
		}

		String ans_1hour = String.valueOf(team1_min);
		String ans_1min = String.valueOf(team1_sec);
		String ans_2hour = String.valueOf(team2_min);
		String ans_2min = String.valueOf(team2_sec);

		if (team1_min <= 9) {
			ans_1hour = "0" + team1_min;
		}

		if (team1_sec <= 9) {
			ans_1min = "0" + team1_sec;
		}

		if (team2_min <= 9) {
			ans_2hour = "0" + team2_min;
		}

		if (team2_sec <= 9) {
			ans_2min = "0" + team2_sec;
		}

		System.out.println(ans_1hour + ":" + ans_1min);
		System.out.println(ans_2hour + ":" + ans_2min);

	}

	static void checker(int tempTeam, String tempTime) {

		int tempMin = Integer.parseInt(tempTime.substring(0, 2));
		int tempSec = Integer.parseInt(tempTime.substring(3, 5));

		if (count != 0) {

			int diffMin = tempMin - set_min;
			int diffSec = tempSec - set_sec;

			if (diffSec < 0) {
				diffMin -= 1;
				diffSec = 60 + diffSec;
			}

			if (team_1 > team_2) {
				team1_min += diffMin;
				team1_sec += diffSec;
			} else if (team_1 < team_2) {
				team2_min += diffMin;
				team2_sec += diffSec;
			}

		}

		if (tempTeam == 1) {
			team_1++;
		} else {
			team_2++;
		}

		count++;
		set_min = tempMin;
		set_sec = tempSec;
	}

}

