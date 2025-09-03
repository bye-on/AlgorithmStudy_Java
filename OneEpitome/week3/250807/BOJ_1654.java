import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static List<Integer> cardOfGyu;
	public static int gyuWin = 0;
	public static int inWin = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Long> length_arr = new ArrayList<>();
		
		String[] split = br.readLine().split(" ");
		int K = Integer.parseInt(split[0]), N = Integer.parseInt(split[1]);
		
		for (int i=0; i<K; i++) {
			length_arr.add(Long.parseLong(br.readLine()));
		}
		
		long start = 1;
		long end = Collections.max(length_arr);
		
		while (start <= end) {
			Long mid = (start+end) / 2;
			
			if (evaluate(length_arr, mid, N)) {
				start = mid+1;
				continue;
			} else {
				end = mid-1;
				continue;
			}
		}
		
		System.out.println(end);
	}
	
	private static boolean evaluate(List<Long> length_arr, long parameter, int determinant) {
		int t = 0;
		
		for (Long len : length_arr) {
			t += (len / parameter);
		}
		
		if (t >= determinant) {
			return true;
		}
		
		return false;
	}
}
