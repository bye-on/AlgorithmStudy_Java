import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 총 사람 수
        int K = sc.nextInt(); // 제거할 사람의 간격

        List<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        System.out.print("<");

        int index = 0;

        while (circle.size() > 0) {
            index = (index + K - 1) % circle.size(); // 제거할 인덱스 계산
            int removed = circle.remove(index);

            if (circle.size() > 0) {
                System.out.print(removed + ", ");
            } else {
                System.out.print(removed);
            }
        }

        System.out.println(">");
        sc.close();
    }
}

