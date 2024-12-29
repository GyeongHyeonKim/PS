package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 이분탐색
 * 
 * H가 0이 가능하므로, start를 -1로 잡아야한다
 *
 */
public class 어깨동무 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static int[] heights;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		int res = solve();
		System.out.println(res);
	}
	static int solve() {
		
		
		int start = -1;
		int end = 1000000000;
		
		while(start+1<end) {
			int mid = (start+end)/2;
			if(check(mid)) {
				end = mid;
			}
			else {
				start = mid;
			}
			
		}
		return end;
	}
	static boolean check(int target) {
		
		int num = 0;
		if(N >= 2) {
			if(Math.abs(heights[0] - heights[1]) > target)num++;
			if(num > K)return false;
		}
		
		if(num > K)return false;
		
		for(int idx=1;idx<N-1;idx++) {
			
			int left = Math.abs(heights[idx] - heights[idx-1]);
			int right = Math.abs(heights[idx] - heights[idx+1]);
			
			if(left > target || right > target)num++;
			if(num > K)return false;
		}
		
		if(N >= 2) {
			if(Math.abs(heights[N-1] - heights[N-2]) > target)num++;
			if(num > K)return false;
		}
		return true;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		heights = new int[N];
		for(int idx=0;idx<N;idx++) {
			heights[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
