package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 
 * 그리디 + 구현
 * 
 *
 */

public class 양팔저울 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		int res = solve();
		System.out.println(res);
	}
	static int solve() {
		
		int leftSum = arr[0];
		int rightSum = arr[1];
		for(int idx=2;idx<N;idx++) {
			
			if(leftSum == rightSum) {
				leftSum += arr[idx];
			}
			else {
				if(leftSum > rightSum) {
					rightSum += arr[idx];
				}
				else leftSum += arr[idx];
			}
			
		}
		
		// 필요한 무게추의 수 구하기
		int diff = Math.abs(rightSum - leftSum);
		
		int cnt = 0;
		if(diff / 100 != 0) {
			cnt += diff/100;
			diff = diff%100;
		}
		if(diff / 50 != 0) {
			cnt += diff/50;
			diff = diff%50;
		}
		if(diff / 20 != 0) {
			cnt += diff/20;
			diff = diff%20;
		}
		if(diff / 10 != 0) {
			cnt += diff/10;
			diff = diff%10;
		}
		if(diff / 5 != 0) {
			cnt += diff/5;
			diff = diff%5;
		}
		if(diff / 2 != 0) {
			cnt += diff/2;
			diff = diff%2;
		}
		if(diff / 1 != 0) {
			cnt += diff/1;
			diff = diff%1;
		}
		return cnt;
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
