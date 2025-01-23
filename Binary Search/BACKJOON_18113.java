package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_18113 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K,M;
	static int[] arr;
//	static List<Integer> alist = new ArrayList<>();
	static int[] alist;
	static int num;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		int res = solve();
		if(res == 0)res = -1;
		System.out.println(res);
	}
	static int solve() {
		
		int start = 0;
		int end = 1000000001;
		
		while(start+1 < end) {
			int mid = (start+end)/2;
			
			if(check(mid)) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		return start;
	}
	static boolean check(int target) {
		
		int sum = 0;
		for(int idx=0;idx<num;idx++) {
			sum += alist[idx] / target;
			if(sum >= M)return true;
		}
		return false;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		alist = new int[N];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[idx] = Integer.parseInt(st.nextToken());
			
			if(arr[idx] >= 2*K) {
				alist[num++] = arr[idx]-2*K;
			}
			else if(arr[idx] > K) {
				alist[num++] = arr[idx]-K;
			}
		}
	}

}
