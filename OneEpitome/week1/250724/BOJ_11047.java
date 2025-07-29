import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]), K = Integer.parseInt(split[1]);
		
		List<Integer> coins = new ArrayList<>();
		for (int i=0; i<N; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(coins);
		Collections.reverse(coins);
		
		
		int result = 0;
		for (int coin : coins) {
			result += K / coin;
			K = K % coin;
		}
		
		System.out.println(result);
	}
}

