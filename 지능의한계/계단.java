package ct;

import java.util.*;
import java.io.*;

/**
 * 그리디 문제
 * 
 * 맨 앞부터 하나씩 게단을 쌓는다고 생각해보자.
 * 
 * 1부터 시작하는데 다음칸이 만약 현재보다 계단의 높이보다 높다면, 2로 증가시키면 된다.
 * 
 * 만약 다음이 현재보다 작다면, 최소한 다음 수 이전까지의 값을 이용하여 다음 수 높이의 계단을 만들 수 있으므로
 * 
 * 계단의 높이를 다음 히스토그램의 높이로 변경한다
 *
 */
public class 계단 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{	
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int curHeight = 1;
		int maxHeight = 1;
		for(int idx=1;idx<N;idx++) {
			
			if(curHeight < arr[idx]) {
				curHeight++;
				maxHeight = Math.max(maxHeight, curHeight);
			}
			else{
				curHeight = arr[idx];
			}
			
		}
		System.out.println(maxHeight);
		
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
