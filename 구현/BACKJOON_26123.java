package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 구현문제.
 * 
 * 가장 높은 빌딩의 높이로부터 1씩 감소한다는걸 발견
 * 
 *
 */
public class BACKJOON_26123 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,D;
	static int[] heights;
	static int maxHeight;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		long sum = 0;
		int shoot = 0;
		for(int h=maxHeight;h>=1;h--) {
			shoot++;
			sum += heights[h];
			heights[h-1] += heights[h];
			if(shoot == D)break;
		}
		System.out.println(sum);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		
		heights = new int[300001];
		for(int idx=0;idx<N;idx++) {
			int h = Integer.parseInt(st.nextToken());
			heights[h]++;
			maxHeight = Math.max(maxHeight, h);
		}
	}

}
