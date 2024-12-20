package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 투 포인터 문제 
 * 
 *
 */

public class 고양이카페 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		int sum = 0;
		while(start < end) {
			if(arr[start]+arr[end] <= K) {
				start++;
				end--;
				sum++;
			}
			else if(arr[start]+arr[end] > K) {
				end--;
			}
		}
		System.out.println(sum);
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
