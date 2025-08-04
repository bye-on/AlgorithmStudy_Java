import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] time = new int[n + 1];       
        int[] indegree = new int[n + 1];    
        int[] earliest = new int[n + 1];   

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            earliest[i] = time[i];  

            int k = Integer.parseInt(st.nextToken()); 
            for (int j = 0; j < k; j++) {
                int pre = Integer.parseInt(st.nextToken());
                graph[pre].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int v : graph[q]) {
                earliest[v] = Math.max(earliest[v], earliest[q] + time[v]);

                if (--indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, earliest[i]);
        }

        System.out.println(answer);
    }
}
