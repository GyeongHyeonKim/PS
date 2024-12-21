package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * Parametric Search
 * 
 * start를 옮기는것에 주의하며, 0이 답이 될 수 있으므로 start가 -1이 시작이여야 한다
 * 
 * - end를 불가능한 경우로 설정하면, end가 0인경우 start는 -1이 되어야 하기 때문
 * 
 * 
 *
 */

public class 이상한술집 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		long res = solve();
		System.out.println(res);
	}
	static long solve() {
		
		long start = -1;
		long end = Integer.MAX_VALUE;
		
		while(start+1<end) {
			
			long mid = (start+end)/2;
			
			if(check(mid)) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		if(start == -1)return 0;
		else return start;
	}
	static boolean check(long target) {
		
		long sum =  0;
		for(int idx=0;idx<N;idx++) {
			if(arr[idx] == 0)continue;
			
			sum += arr[idx] / target;
			if(sum >= K)return true;
		}
		return false;
	}
	
	static void setInitVariable() throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
