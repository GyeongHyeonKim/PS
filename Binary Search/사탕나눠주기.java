package ct;

import java.util.*;
import java.io.*;


public class 사탕나눠주기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static long K;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		long res = solve();
		System.out.println(res);
	}
	static long solve() {
		
		long start = -1;
		long end = 1_000_000_000_000L;
		
		
		while(start+1<end) {
			long mid = (start+end)/2;
			
			if(check(mid)) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		return end;
	}
	static boolean check(long target) {
		
		long sum = 0;
		for(int idx=0;idx<N;idx++) {
			
			if(target > arr[idx])continue;
			else {
				sum += arr[idx]-target;
			}
			if(sum > K)return false;
			
		}
		return true;
	}
	
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		arr = new long[N];
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Long.parseLong(st.nextToken());
		}
	}

}
