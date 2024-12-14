package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 스택으로 풀려다가 너무 꼬여서 포기함
 * 
 * 게시판 설명보고 이해
 * 
 * 11,3,4,5,3,4,5,3,4,5,7 이 들어왔다면,
 * 
 * 11 [3] 4 5 3 4 5 3 4 5 7 
 * 
 * 에서 [3]에는 몇 만큼의 물이 차야할까?
 * 
 * [3]의 왼쪽에 있는것 중 가장높은건 11이고
 * 오른쪽에 있는 것 중에 가장 높은건 7이다.
 * 
 * 따라서 [3]에는 높이7까지 물이 채워진다..
 *
 */

public class 빗물 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int H,W;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int sum = 0;
		for(int idx=0;idx<W;idx++) {
			
			int leftMax = -1;
			int rightMax = -1;
			for(int left = 0;left<idx;left++) {
				leftMax = Math.max(leftMax, arr[left]);
			}
			for(int right = idx+1;right<W;right++) {
				rightMax = Math.max(rightMax, arr[right]);
			}
			
			if(leftMax == -1 || rightMax == -1)continue;
			if(leftMax > arr[idx] && arr[idx] < rightMax) {
				int maxHeight = Math.min(leftMax, rightMax);
				sum += maxHeight - arr[idx];
			}
			
		}
		System.out.println(sum);
	}
	static void calculate(Deque<Integer> stack) {
		
		  
	}
	
	static void setInitVariable() throws IOException{
		st =  new StringTokenizer(br.readLine().trim());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		st =  new StringTokenizer(br.readLine().trim());
		arr = new int[W];
		for(int idx=0;idx<W;idx++) {
			int v = Integer.parseInt(st.nextToken());
			arr[idx] = v;
		}
	}

}
