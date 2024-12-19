package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 단순 정렬문제 
 *
 */

public class BACKJOON_28464 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static List<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Collections.sort(arr,Collections.reverseOrder());
		
		int A = 0;
		int B = 0;
		
		if(N == 1) {
			System.out.print(0+" "+arr.get(0));
			return;
		}
		
		int start = 0;
		int end = N-1;
		while(start<=end) {
			if(start == end) {
				A += arr.get(start);
				break;
			}
			A += arr.get(start);
			B += arr.get(end);
			start++;
			end--;
		}
		System.out.print(B+" "+A);
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
	}

}
