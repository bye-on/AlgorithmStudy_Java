import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]), M = Integer.parseInt(split[1]);
		
		List<List<Integer>> mat = new ArrayList<>();
		for (int i=0; i<N; i++) {
			List<Integer> temp = new ArrayList<>();
			for (String s : br.readLine().split(" ")) {
				
				temp.add(Integer.parseInt(s));
			}
			mat.add(temp);
		}
		
		List<List<Integer>> acc_mat = new ArrayList<>(mat);
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if ((i-1)>=0) acc_mat.get(i).set(j, acc_mat.get(i).get(j) + acc_mat.get(i-1).get(j));
				if ((j-1)>=0) acc_mat.get(i).set(j, acc_mat.get(i).get(j) + acc_mat.get(i).get(j-1));
				if (((i-1)>=0) && (j-1)>=0) acc_mat.get(i).set(j, acc_mat.get(i).get(j) - acc_mat.get(i-1).get(j-1));
			}
		}
		
		for (int i=0; i<M; i++) {
			split = br.readLine().split(" ");
			int x1 = Integer.parseInt(split[0]), y1 = Integer.parseInt(split[1]), x2 = Integer.parseInt(split[2]), y2 = Integer.parseInt(split[3]);
			
			int ret = acc_mat.get(x2-1).get(y2-1);
			if (x1>1) ret -= acc_mat.get(x1-2).get(y2-1);
			if (y1>1) ret -= acc_mat.get(x2-1).get(y1-2);
			if ((x1>1) && (y1>1)) ret += acc_mat.get(x1-2).get(y1-2);
			
			System.out.println(ret);
		}
	}
}

