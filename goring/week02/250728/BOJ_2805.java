package forStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
	static int[] arr;
	static int N;
	static int M;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        if(N==1) System.out.println(arr[0] - M);
        else System.out.println(findMax());
    }
    
    static long findMax() {
    	long sum = 0L;
        int i;
        for(i=1; i<N; i++) {
        	if(sum+(arr[N-i]-arr[N-i-1])*i < M) {
        		sum+= (arr[N-i]-arr[N-i-1])*i;
        	}
        	else return (M-sum)%i==0 ? arr[N-i]-(M-sum)/i : arr[N-i]-((M-sum)/i+1);
        }
        if((M-sum)%i==0) return arr[N-i]-(M-sum)/i;
        else return arr[N-i]-((M-sum)/i+1);
    }
}

