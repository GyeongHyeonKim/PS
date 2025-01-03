package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 그리디.
 * 
 * 시계방향으로 돌면서 오름차순이 아닌순간 자르기
 *
 */
public class BACKJOON_28136 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int before = 0;
		int next = 1;
		int cut = 0;
		while(true) {
			if(arr[before] >= arr[next]) {
				cut++;
			}
			before = next;
			next = (next+1)%N;
			if(next == 1) {
				System.out.println(cut);
				return;
			}
		}
		
		
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
