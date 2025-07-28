import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p_1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        int current = 1;
        boolean flag = true;

        while (!queue.isEmpty()) {
            int target = queue.peek();

            if (current <= target) {
                while (current <= target) {
                    stack.push(current++);
                    result.add("+");
                }
            }

            if (stack.peek() == target) {
                stack.pop();
                queue.poll();
                result.add("-");
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            for (String op : result) {
                System.out.println(op);
            }
        } else {
            System.out.println("NO");
        }
    }
}