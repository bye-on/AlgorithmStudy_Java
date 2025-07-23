package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BOJ_1260 {
    static Map<Integer, List<Integer>> graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int M = Integer.parseInt(line.split(" ")[1]);
        int V = Integer.parseInt(line.split(" ")[2]);
    
        graph = new HashMap<>();
        for(int i=1; i<=N; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i =0; i<M; i++){
            line = br.readLine();
            int start = Integer.parseInt(line.split(" ")[0]);
            int finish = Integer.parseInt(line.split(" ")[1]);

            graph.get(start).add(finish);
            graph.get(finish).add(start);
        }
        
		for(int key : graph.keySet()) {
			Collections.sort(graph.get(key));
		}
		
        StringBuilder sb = new StringBuilder();
		for(int i : dfs(V, new ArrayList<Integer>())) {
			sb.append(i + " ");
		}
        sb.append("\n");

		for(int i : bfs(V)) {
			sb.append(i + " ");
		}

        System.out.println(sb);
    }

    static List<Integer> dfs(int v, List<Integer> discovered){
        discovered.add(v);

        for(Integer w : graph.get(v)){
            if (!discovered.contains(w)) {
                discovered = dfs(w, discovered);
            }
        }

        return discovered;
    }

    static List<Integer> bfs(int v){
        List<Integer> discovered = new ArrayList<>();
        discovered.add(v);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int w : graph.get(tmp)){
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }

        return discovered;
    }
}
