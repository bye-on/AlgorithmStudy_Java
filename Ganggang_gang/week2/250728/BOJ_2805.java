//2805번 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i =0; i<n ; i++ ) {
			arr.add(Integer.parseInt(st2.nextToken()));
		}
		
		arr.sort(null);
		int left = 0;
		int right = arr.get(n-1);
		int ans = 0;

		while (left <= right) {
		    int mid = (left + right) / 2;

		    long value = 0;
		    for (int a : arr) {
		        if (a > mid) value += (a - mid);
		    }

		    if (value >= m) {
		        ans = mid;
		        left = mid + 1;
		    } else {
		        right = mid - 1;
		    }
		}

		System.out.println(ans);
		
		
	}
}
