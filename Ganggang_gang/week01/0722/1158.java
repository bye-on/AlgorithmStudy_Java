import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int cnt = 1;
		sb.append('<');
		for(int i = 1 ; i <= n; i++) {
			queue.add(i);
		}
		while(!queue.isEmpty()) {
			int tmp = queue.poll(); //원형 테이블의 특징이 있기 때문에 큐 형식을 유도했습니다.
			if(cnt == k ) {
				if(queue.isEmpty()) sb.append(tmp); //마지막 원소일 경우
				else sb.append(tmp).append(',').append(' ');
				cnt=1;
			}
			else {
				queue.add(tmp); //해당되는 번째가 아닌 경우
				cnt += 1;
			}
		}
		sb.append('>');
		System.out.println(sb);
		
	}

}
