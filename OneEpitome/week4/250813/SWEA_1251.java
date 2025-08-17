import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("Test2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] islands = new int[N][2];
			String[] split = br.readLine().split(" ");
			for (int i=0; i<N; i++) {
				islands[i][1] = Integer.parseInt(split[i]);
			}
			split = br.readLine().split(" ");
			for (int i=0; i<N; i++) {
				islands[i][0] = Integer.parseInt(split[i]);
			}
			
			double taxRate = Double.parseDouble(br.readLine());
			List<Integer> arr = new ArrayList<>();
			for (int i=0; i<N; i++) {
				arr.add(i);
			}
			
			PriorityQueue<List<Double>> edges = new PriorityQueue<>(new Comparator<List<Double>>() {

				@Override
				public int compare(List<Double> o1, List<Double> o2) {
					// TODO Auto-generated method stub
					if (o1.get(0) > o2.get(0)) {
						return 1;
					} else if (o1.get(0) < o2.get(0)) {
						return -1;
					}
					return 0;
				}
				
			});
			List<List<Integer>> combinations = combinations(arr, 2);
			for (List<Integer> combination : combinations) {
				int i1 = combination.get(0), i2 = combination.get(1);
				
				double distance = calcDistance(islands, i1, i2);
				edges.add(Arrays.asList(distance, (double) i1, (double) i2));
			}
			
//			while (!edges.isEmpty()) {
//				System.out.println(edges.poll());
//			}
			
			int[] parents = new int[N];
			for (int i=0; i<N; i++) {
				parents[i] = i;
			}
			
			double totalCost = 0;
			while (!edges.isEmpty()) {
//				System.out.println(Arrays.toString(parents));
				List<Double> poll = edges.poll();
				double cost = poll.get(0);
				int a = poll.get(1).intValue();
				int b = poll.get(2).intValue();
				
				if (findParent(parents, a) == findParent(parents, b)) {
					continue;
				} else {
					union(parents, a, b);
					totalCost += taxRate * cost;
				}
			}
			
			System.out.printf("#%d %.0f\n", t+1, totalCost);
		}
	}
	
	public static List<List<Integer>> combinations(List<Integer> arr, int r) {
		List<List<Integer>> result = new ArrayList<>();
		combinations(arr, r, 0, new ArrayList<Integer>(), result, 0);
		return result;
	}
	
	public static void combinations(List<Integer> arr, int r, int depth, List<Integer> output, List<List<Integer>> result, int start) {
		if (depth == r) {
			result.add(new ArrayList<>(output));
			return;
		}
		
		for (int i=start; i<arr.size(); i++) {
			output.add(arr.get(i));
			combinations(arr, r, depth+1, output, result, i+1);
			output.remove(output.size()-1);
		}
	}
	
	public static double calcDistance(int[][] islands , int i1, int i2) {
		return Math.pow(Math.abs(islands[i1][0] - islands[i2][0]), 2) + Math.pow(Math.abs(islands[i1][1] - islands[i2][1]), 2);
	}
	
	public static int findParent(int[] parents, int x) {
		if (parents[x] != x) {
			parents[x] = findParent(parents, parents[x]);
		}
		
		return parents[x];
	}
	
	public static void union(int[] parents, int a, int b) {
		int parentOfA = findParent(parents, a);
		int parentOfB = findParent(parents, b);
		
		if (parentOfA > parentOfB) {
			parents[parentOfA] = parentOfB;
		} else {
			parents[parentOfB] = parentOfA;
		}
	}
}

