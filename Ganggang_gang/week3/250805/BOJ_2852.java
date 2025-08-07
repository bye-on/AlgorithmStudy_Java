import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] score = new int[2][3];
		int[] timetable = new int[n];
		int[] win = new int[n];
		for(int i =0; i<n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), ":");
			String str = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(str, " ");
			
			win[i] = Integer.parseInt(st2.nextToken());
			int hr = Integer.parseInt(st2.nextToken());
			int mm = Integer.parseInt(st.nextToken());
			timetable[i] = (hr*60) + mm;
//			System.out.println(score[0][1] + " " + score[0][2]);
			
			
			
			//마지막 입력일때
		}
		
		for(int i=0; i<n; i++) {
			score[0][win[i]] += 1;
			if(i == n - 1) {
//				score[0][team] += 1;
				if (score[0][1] > score[0][2]) {
					int lasttime = Math.abs(timetable[i] - 2880);
					score[1][1] += lasttime;
				}
				else if(score[0][1] < score[0][2]) {
					int lasttime = Math.abs(timetable[i] - 2880);
					score[1][2] += lasttime;
				}
			}
			
			else {
				if (score[0][1] > score[0][2]) {
					int lasttime = Math.abs(timetable[i] - timetable[i+1]);
					score[1][1] += lasttime;
				}
				else if(score[0][1] < score[0][2]) {
					int lasttime = Math.abs(timetable[i] - timetable[i+1]);
					score[1][2] += lasttime;
				}
			}
			
			
		}
		
		
		for(int i=1; i<=2;i++) {
			if(score[1][i]/60 <10) {
				System.out.print("0"+ score[1][i]/60 + ":");
			}
			else {
				System.out.print(score[1][i]/60 + ":");
			}
			
			if(score[1][i] % 60 < 10) {
				System.out.println("0"+ (score[1][i]%60));
			}
			else {
				System.out.println((score[1][i]%60));
			}
			
		}
	}
}
