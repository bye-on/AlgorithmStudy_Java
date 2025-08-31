
import java.io.*;
import java.util.*;

public class BOJ_11053 {

	static int ans, A;
	static int[] arr;
	static int[] LIS;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		A = Integer.parseInt(br.readLine());

		arr = new int[A];
		LIS = new int[A];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

//		Arrays.sort(arr); //아 정렬된 배열이아니라 정렬이 안된 배열에서만 사용가능

		int size = 0;
		for (int i = 0; i < A; i++) {
			int idx = Arrays.binarySearch(LIS, 0, size, arr[i]);
			// LIS배열에서 0~size 중에arr[i]를 찾을거다,
			// 이때 만약 값이 있다면 idx값을 반환해주고
			// 없다면 해당 값이 어디위치에 들어가면 좋을지 idx * -1 -1을 해서 반환해준다.
			if (idx < 0) { // 그래서 만약 idx 가 0 보다 작다면
				idx = (idx * -1) - 1; //
				LIS[idx] = arr[i];
			}
			if (idx == size)
				size++;
			// idx가 size를 늘리는 값일때만 size++해준다.

		}

		System.out.println(size);

	}

}
