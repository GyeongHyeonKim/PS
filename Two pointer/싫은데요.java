package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 투포인터 문제
 * 
 * 앞에서부터 end지점을 늘려가면서, 가능한지 판단한다
 * 
 * 가능한 경우, 합을 누적하며 end를 이동
 * 
 * 불가능한 경우, 가능한 지점까지 start이동
 *
 */

public class 싫은데요 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int start = 0;
		int end  = 0;
		
		int sum = 0;
		int maxSum = 0;
		while(end < N) {
			if(sum +  arr[end] <= M) {
				sum += arr[end];
				maxSum = Math.max(maxSum, sum);
				end++;
			}
			else {
				sum -= arr[start];
				start++;
				
				if(start > end) {
					end = start;
					sum = 0;
				}
			}
		}
		System.out.println(maxSum);
	}
	
	static void setInitVariable() throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
