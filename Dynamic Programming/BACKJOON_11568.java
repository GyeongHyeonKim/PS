package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 다이나믹 프로그래밍
 * 
 * 가장 긴 증가하는 부분수열
 * 
 *
 */

public class BACKJOON_11568 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		for(int idx=0;idx<N;idx++)dp[idx] = 1;
		
		int maxCnt = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i],dp[j]+1);	
					maxCnt = Math.max(maxCnt, dp[i]);
				}
			}
		}
		System.out.println(maxCnt);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		dp = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
