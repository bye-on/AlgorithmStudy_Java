import java.util.*;

public class Main {
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        
        while (!stack.isEmpty()) {
            int now = stack.pop();
            for (int adj : graph.get(now)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    stack.push(adj);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        boolean[] visited = new boolean[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Read edges and build graph
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }
        
        System.out.println(count);
        sc.close();
    }
}
