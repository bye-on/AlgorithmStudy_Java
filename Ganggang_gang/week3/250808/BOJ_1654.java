import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int arr = Integer.parseInt(tokenizer.nextToken());   
        int arr_rc = Integer.parseInt(tokenizer.nextToken());  

        long[] arrlength = new long[arr];
        long max_value = 0;
        for (int i = 0; i < arr; i++) {
            long length = Long.parseLong(reader.readLine());
            arrlength[i] = length;
            if (length > max_value) {
                max_value = length;
            }
        }

        long left = 1;              
        long right = max_value;   
        long answer = 0;           

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (long cable : arrlength) {
                count += cable / mid;
            }

            if (count >= arr_rc) {
                answer = mid;
                left = mid + 1; }

            else {
                right = mid - 1;
            }
        }


        System.out.println(answer);
    }
}
