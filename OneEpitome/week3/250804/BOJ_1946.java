import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] scores = new int[N][2];
			
			for (int i=0; i<N; i++) {
				String[] split = br.readLine().split(" ");
				scores[i][0] = Integer.parseInt(split[0]);
				scores[i][1] = Integer.parseInt(split[1]);
			}
			
			Arrays.sort(scores, new Comparator<int[]>() {
				  public int compare(int[] o1, int[] o2) {
				    if (o1[0] == o2[0])
				      return o1[1] - o2[1];
				    else
				      return o1[0] - o2[0];
				  }
			});
			
			int count = 0;
			int last = scores[0][1];
			
			for (int[] score : scores) {
				int s2 = score[1];
				if (s2 > last) continue;
				
				count += 1;
				last = s2;
			}
			
			System.out.println(count);
		}
	}
}

