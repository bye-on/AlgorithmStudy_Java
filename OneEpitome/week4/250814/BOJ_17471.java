import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean isReachable(int a, int b, List<Set<Integer>> graph, Set<Integer> s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        
        stack.push(a);
        visited[a] = true;
        
        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (now == b) {
                return true;
            }
            
            for (int adj : graph.get(now)) {
                if (!visited[adj] && s.contains(adj)) {
                    stack.push(adj);
                    visited[adj] = true;
                }
            }
        }
        return false;
    }
    
    public static boolean isPossible(Set<Integer> s, List<Set<Integer>> graph) {
        List<Integer> nodes = new ArrayList<>(s);
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (!isReachable(nodes.get(i), nodes.get(j), graph, s)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void generateCombinations(List<Integer> arr, int r, int start, 
                                          List<Integer> current, List<List<Integer>> result) {
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < arr.size(); i++) {
            current.add(arr.get(i));
            generateCombinations(arr, r, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] population = new int[N + 1];
        
        String[] popInput = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(popInput[i - 1]);
        }
        
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j < split.length; j++) {
                int neighbor = Integer.parseInt(split[j]);
                graph.get(i).add(neighbor);
                graph.get(neighbor).add(i);
            }
        }
        
        int result = Integer.MAX_VALUE;
        int populationSum = 0;
        for (int i = 1; i <= N; i++) {
            populationSum += population[i];
        }
        
        Set<Integer> totalSet = new HashSet<>();
        List<Integer> totalList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            totalSet.add(i);
            totalList.add(i);
        }
        
        for (int i = 1; i < N; i++) {
            List<List<Integer>> combinations = new ArrayList<>();
            generateCombinations(totalList, i, 0, new ArrayList<>(), combinations);
            
            for (List<Integer> combination : combinations) {
                Set<Integer> combinationSet = new HashSet<>(combination);
                Set<Integer> complement = new HashSet<>(totalSet);
                complement.removeAll(combinationSet);
                
                if (isPossible(combinationSet, graph) && isPossible(complement, graph)) {
                    int partialPopulation = 0;
                    for (int e : combinationSet) {
                        partialPopulation += population[e];
                    }
                    
                    int diff = Math.abs(populationSum - 2 * partialPopulation);
                    result = Math.min(diff, result);
                }
            }
        }
        
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
