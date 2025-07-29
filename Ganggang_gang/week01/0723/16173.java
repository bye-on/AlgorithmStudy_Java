import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int n;
	static int visited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = dfs(0,0); //dfs 접근 -1에 도달하면 true 그렇지 못하면 false
		
		if (flag == true) System.out.println("HaruHaru");
		else System.out.println("Hing");
		
	}
	
	public static boolean dfs(int x, int y) {
		if (x >= n || y >= n || visited[x][y] == 1) return false;
		if(arr[x][y] == -1) {
			return true;
		}
		visited[x][y] = 1; //시간초과와 무한루프 대비중복된 경우 가짓수 줄이기 위한 확인
		int value = arr[x][y];
		//오른쪽으로 가기
	    if (dfs(x + value, y)) {
	        return true;
	    }
	    // 아래로 가기
	    if (dfs(x, y + value)) {
	        return true;
	    }
		
		return false;
		
	}

}
