import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		int[] arr = new int[n];
		
		for(int i = 0 ; i<n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = n-1 ; i >= 0 ; i-- ) {
			if(money / arr[i] > 0) {
				ans  += (int) (money / arr[i]);
				money = money % arr[i];
			}
			if(money == 0 ) break;
		}
		System.out.println(ans);
		
		
	}

}
