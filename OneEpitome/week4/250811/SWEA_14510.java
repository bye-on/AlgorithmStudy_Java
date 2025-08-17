import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] trees = new int[N];
			String[] split = br.readLine().split(" ");
			
			int maxHeight = 0;
			for (int i=0; i<N; i++) {
				trees[i] = Integer.parseInt(split[i]);
				maxHeight = Math.max(maxHeight, trees[i]);
			}
			
			Queue<Integer> list1 = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Integer> list2 = new PriorityQueue<>(Collections.reverseOrder());
			for (int i=0; i<N; i++) {
				int growUp = maxHeight - trees[i];
				
				switch (growUp) {
					case 0:
						break;
					case 1:
						list1.add(growUp);
						break;
					default:
						list2.add(growUp);
				}
			}
			
			int turn = 0;
			while (!list1.isEmpty() || !list2.isEmpty()) {
				if ((turn % 2) == 0) {
					if (!list1.isEmpty()) {
						list1.poll();
					} else if (list2.size() > 1) {
						int poll = list2.poll();
						poll -= 1;
						
						if (poll == 1) {
							list1.add(poll);
						} else {
							list2.add(poll);
						}
					}
					
					turn++;
				} else {
					if (!list2.isEmpty()) {
						int poll = list2.poll();
						poll -= 2;
						
						if (poll == 1) {
							list1.add(poll);
						} else if (poll > 1) {
							list2.add(poll);
						}
					}
					
					turn++;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, turn);
		}
	}
}

