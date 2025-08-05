import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i =0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s= Integer.parseInt(st.nextToken());
			if(s == 0 ) {
				if(arr.isEmpty()) System.out.println(-1);
				else { 
					System.out.println(arr.get(arr.size()-1));
					arr.remove(arr.size()-1);
				}
			}
			else {
				for(int j=0; j<s; j++) {
					arr.add(Integer.parseInt(st.nextToken()));
				}
				Collections.sort(arr);
			}
		}
	}
	
}
