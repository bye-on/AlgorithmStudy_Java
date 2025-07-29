import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int value = (int) Math.pow(n, 2);
		int mid = n/2; //왼쪽 상단 대각선에서 아래로 간다는 접근으로 시도
		int[][] arr = new int[n][n];
		
		for(int k =0; k<mid; k++) {
			//왼쪽 모서리
			for(int i =k ; i<n-k; i++ ) {
				if (arr[i][k] != 0 ) break; //범위 이탈하는 예외 처리
				arr[i][k] = value;
				if (value == target) sb.append(i+1).append(' ').append(k+1); 
				value--;
			}
			
			
			
			//아래모서리
			for(int i= k+1; i<n-k; i++) {
				if (arr[n-1-k][i] != 0 ) break;
				arr[n-1-k][i] = value;
				if (value == target) sb.append(n-k).append(' ').append(i+1); 
				value--;
			}
			
			//오른쪽 모서리
			for(int i = n-k-2; i >= k ; i--) {
				if (arr[i][n-k-1] != 0 ) break;
				arr[i][n-k-1] = value;
				if (value == target) sb.append(i+1).append(' ').append(n-k); 
				value--;
			}
			
			
			//위쪽 모서리
			for(int i = n-k-2; i >= 1+k ; i--) {
				if(arr[k][i] != 0 ) break;
				arr[k][i] = value;
				if (value == target) sb.append(k+1).append(' ').append(i+1); 
				value--;
			} 
		}
		arr[mid][mid] = 1;
		if(target == 1) {
			sb.append(mid+1).append(' ').append(mid+1);
		}
		
		for(int i=0; i<n; i++) {
			StringBuilder sb1 = new StringBuilder();
			for(int j=0; j<n; j++) {
				sb1.append(arr[i][j]).append(' ');
			}
			System.out.println(sb1);
		}
		System.out.println(sb);
		
	}

}
