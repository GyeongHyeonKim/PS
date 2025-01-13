package ct;

import java.util.*;
import java.io.*;

/**
 * 그리디
 * 
 * 묶어야하는데.. N이 10만이라 힘들것같아 그리디로 접근
 * 
 * 정렬 후 가장 낮은값과 높은값을 묶어보니 답 같았다.
 * 
 * 
 *
 */
public class BACKJOON_20117 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Arrays.sort(arr);
		int start = 0;
		int end = N-1;
		int sum = 0;
		while(start <= end) {
			if(start == end) {
				sum += arr[end];
				break;
			}
			sum += arr[end]*2;
			start++;
			end--;
		}
		System.out.println(sum);
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
