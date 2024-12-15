package ct;

import java.util.*;
import java.io.*;

/**
 * 부분집합 문제
 * 
 *
 */

public class BACKJOON_14225 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static boolean[] selected;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve(0,0);
		
		for(int idx=1;idx<=20000000;idx++) {
			if(!selected[idx]) {
				System.out.println(idx);
				return;
			}
		}
	}
	static void solve(int start,int sum) {
		
		if(start == N) {
			
			selected[sum] = true;
			return;
		}
		//선택하는경우
		solve(start+1,sum+arr[start]);
			
		// 선택안하는경우
		solve(start+1,sum);
		
		
	}
	static void setInitVariable() throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		selected = new boolean[20000001];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
			selected[arr[idx]] = true;
		}
		
	}

}
