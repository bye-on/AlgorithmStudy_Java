import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int T = Integer.parseInt(br.readLine());

         for (int i = 0; i < T; i++) {
             List<Integer> list = Arrays.stream(br.readLine().split(" "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());

             Integer N = list.get(0);
             Integer Q = list.get(1);

             String[] priorityOfDocumentTokens = br.readLine().split(" ");
             List<List<Integer>> indexAndPriorityOfDocuments = IntStream.range(0, priorityOfDocumentTokens.length)
                     .mapToObj(index -> List.of(index, Integer.parseInt(priorityOfDocumentTokens[index])))
                     .collect(Collectors.toList());

             Deque<List<Integer>> q = new LinkedList<>(indexAndPriorityOfDocuments);

             int count = 0;
             while  (!q.isEmpty()) {
                 List<Integer> poll = q.poll();
                 boolean isPrintable = true;

                 for (List<Integer> e : q) {
                     if (e.get(1) > poll.get(1)) {
                         isPrintable = false;
                         break;
                     }
                 }

                 if (isPrintable) {
                     count++;
                 } else {
                     q.addLast(poll);
                     continue;
                 }

                 if (poll.get(0).equals(Q)) {
                     System.out.println(count);
                     break;
                 }
             }
         }
     }
 }