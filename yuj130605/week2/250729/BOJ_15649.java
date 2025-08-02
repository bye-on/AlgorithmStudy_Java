import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15649 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=1; i<=N; i++) {
			arr[i-1] = i;
		}
		
		List<List<Integer>> results = permute(arr, N, M, new boolean[N], 
				new ArrayList<>(), new ArrayList<>(), 0);
		
		StringBuilder sb = new StringBuilder();
		for(List<Integer> result : results) {
			for(Integer i : result) {
				sb.append(i+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static List<List<Integer>> permute(int[] arr, int N, int M, boolean[] visited, 
			List<Integer> current, List<List<Integer>> result, int depth){
		
		if(depth == M) {
			result.add(new ArrayList<>(current));
			return result;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				current.add(arr[i]);
				permute(arr, N, M, visited, current, result, depth+1);
				visited[i]=false;
				current.remove(current.size() - 1);
				
			}
		}
		return result;
	}
}
