import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for (int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		List<List<Integer>> dm = List.of(List.of(1, 0), List.of(0, 1));
		
		Queue<List<Integer>> q = new LinkedList<>();
		q.add(List.of(0, 0));
		
		boolean possible = false;
		while (!q.isEmpty()) {
			List<Integer> now = q.poll();
			
			int r = now.get(0);
			int c = now.get(1);
			
			if (arr[r][c] == 0) {
				continue;
			}
			
			if ((r == N-1) && (c == N-1)) {
				possible = true;
				break;
			}
			
			for (List<Integer> d : dm) {
				int dr = d.get(0);
				int dc = d.get(1);
				
				int nr = r + dr * arr[r][c];
				int nc = c + dc * arr[r][c];
				
				if ((0 <= nr) && (nr < N) && (0 <= nc) && (nc < N)) {
					q.add(List.of(nr, nc));
				}
			}
		}
		
		if (possible) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}
}

