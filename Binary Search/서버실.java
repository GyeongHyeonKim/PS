package ct;

import java.util.*;
import java.io.*;

/**
 * 이분 탐색
 *
 */
public class 서버실 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static long total;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		int res = solve();
		System.out.println(res);
	}
	static int solve() {
		
		//1. 정렬
//		Arrays.sort(arr);
//		
//		for(int idx=0;idx<N*N;idx++) {
//			System.out.print(arr[idx]+" ");
//		}
//		System.out.println();
//		
		
		//2. 탐색
		int start = -1;
		int end = 10000000;
		
		while(start+1<end) {
			int mid = (start+end)/2;
			
//			System.out.print("mid : "+mid);
			if(check(mid)) {
				end = mid;
			}else {
				start = mid;
			}
		}
		
		return end;
	}
	static boolean check(int target) {
		
		long sum = 0;
		for(int idx=0;idx<N*N;idx++) {
			
			if(arr[idx] <= target) {
				sum += arr[idx];
			}
			else {
				sum += target;
			}
			
			if(sum >= (double)total/2)return true;
		}
		return false;
	}	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		arr =  new int[N*N];
		int idx = 0;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=1;j<=N;j++) {
				arr[idx] = Integer.parseInt(st.nextToken());
				total += arr[idx];
				idx++;
			}
		}
		
	}

}
