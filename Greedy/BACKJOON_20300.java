package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 그리디 문제이지만..
 * 
 * 이분탐색에 너무 찌들어있어서 이미 답을 구했음에도 또 이분탐색으로 M을 찾는짓을했다.
 * 
 * 근데 답이 나와야하는데 안나와서 살펴보니.. 이분탐색의 end범위를 잘못주고있었다.
 * 
 * 2개의 합이 end가 되어야하므로, end값은 최대 100..000이 아니라 200..00이 되어야한다.
 *
 */

public class BACKJOON_20300 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static long[] arr;
	static long[] sumArr;
	static int len;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		long res = solve();
		System.out.println(res);
	}
	static long solve() {
		
//		Arrays.sort(arr);
		
//		for(int idx=0;idx<N;idx++) {
//			System.out.print(arr[idx]+" ");
//		}
//		System.out.println();
//		
//		for(int idx=0;idx<N;idx++) {
//			System.out.print(sumArr[idx]+" ");
//		}
//		System.out.println();
		
		long start = -1;
		long end = 2000000000000000000L;
		
		while(start+1<end) {
			long mid = (start+end)/2;
			
//			System.out.println("mid : "+mid);
			if(check(mid)) {
				end = mid;
			}else {
				start = mid;
			}
		}
		
		return end;
	}
	static boolean check(long target) {
		
		for(int i=0;i<len;i++) {
			if(sumArr[i] > target)return false;
		}
		return true;
	}
	
	static void setInitVariable() throws IOException{
		st  = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		st  = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Long.parseLong(st.nextToken());
		}
		
		//여기서 정렬을 하고 합을 찾아야함..
		Arrays.sort(arr);
		
//		long max = -1;
		if(N%2 == 0) {
			sumArr = new long[N/2];
			len = N/2;
			for(int idx=0;idx<len;idx++) {
				sumArr[idx] = arr[idx]  + arr[N-idx-1];
//				max = Math.max(max, sumArr[idx]);
			}
		}
		else {
			sumArr = new long[(N/2) + 1];
			len = (N/2)+1;
			for(int idx=0;idx<N/2;idx++) {
				sumArr[idx] = arr[idx]+arr[N-idx-2];
//				max = Math.max(max, sumArr[idx]);
			}
			sumArr[N/2] = arr[N-1];
//			max = Math.max(max, sumArr[N/2]);
		}
		
//		System.out.println(max);
		
	}

}
