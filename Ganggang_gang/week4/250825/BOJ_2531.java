import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2531 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int  d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] visited = new int[3001];
		int[] arr = new int[n+ (d%n)];
		int cnt = 0;
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i< (d%n); i++) {
			arr[n+i] = arr[i];
		}
		
//		System.out.println(Arrays.toString(arr));
		
		//큐 초기 세팅
		for(int i =0; i<k ;i++) {
			int val = arr[i];
			q.offer(val);
			visited[val] += 1;
			if(visited[val] == 1) {
				cnt += 1;
			}
		}
//		System.out.println(cnt);
		//초기 사이즈 구하기
		if(cnt == k && visited[c] == 0) ans = Math.max(ans, cnt+1);
		else ans = Math.max(ans, cnt);
//		System.out.println(cnt);
		
		for(int i = k; i < (n + (d%n)); i++) {
			
			
//			System.out.println("번째 " + i + "cnt " + cnt);
			
			int tmp = q.poll();
			if(visited[tmp] > 1) {
				visited[tmp]--;
			}
			else {
				visited[tmp]--;
				cnt--;
			}
			
			int value = arr[i];
			q.offer(value);
			if(visited[value] == 0 ) {
				visited[value]++;
				cnt ++;
			}
			else {
				visited[value]++;
			}
//			for(int j = 1; j<=30; j++) {
//				System.out.print(visited[j] + " ");
//			}
//			System.out.println();
			
			if(visited[c] == 0) {
				ans = Math.max(ans, cnt+1);
			}
			else {
				ans = Math.max(ans, cnt);
			}
//			System.out.println(cnt);
			
		}
		System.out.println(ans);
		
		
	}

}
