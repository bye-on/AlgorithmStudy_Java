import java.io.*;
import java.util.*;

public class Main {
    private static final Set<Character> BRACKETS = Set.of('(', ')', '{', '}', '[', ']');
    private static final Map<Character, Character> BRACKET_PAIRS = Map.of(
        '(', ')',
        '{', '}',
        '[', ']'
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;

            List<Character> tBrackets = new ArrayList<>();
            for (char c : line.toCharArray()) {
                if (BRACKETS.contains(c)) {
                    tBrackets.add(c);
                }
            }

            if (isComplete(tBrackets)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isComplete(List<Character> arr) {
        if (arr.isEmpty()) return true;

        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket : arr) {
            if (BRACKET_PAIRS.containsKey(bracket)) {
                stack.push(bracket);
            } else {
                if (!stack.isEmpty() && BRACKET_PAIRS.get(stack.peek()) == bracket) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
