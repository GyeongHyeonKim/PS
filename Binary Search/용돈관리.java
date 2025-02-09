package ct;

import java.util.*;
import java.io.*;

public class 용돈관리 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		int res = solve();
		System.out.println(res);
		
	}
	
	static int solve() {
		
		int start = 0;
		int end = 1000000000;
		
		while(start+1<end) {
			int mid = (start+end)/2;
			
			if(check(mid)) {
				end = mid;
			}
			else start = mid;
		}
		
		return end;
		
	}
	
	static boolean check(int target) {
		
		int numWithdraw = 1;
		int remainder = target;
		
		for(int idx=0;idx<N;idx++) {
			
			if(remainder >= arr[idx]) {
				remainder -= arr[idx];
			}
			else {
				remainder = target;
				if(remainder < arr[idx])return false;
				remainder -= arr[idx];
				numWithdraw++;
			}
		}
		
		if(numWithdraw > M)return false;
		return true;
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
