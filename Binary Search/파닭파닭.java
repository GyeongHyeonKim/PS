package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 이분탐색을 통해 넣을 수 있는 가장 큰 파의 길이를 찾는다.
 * 
 * 3 5
 * 10
 * 10
 * 10
 * 
 * 의 반례에 주의한다...  길이 5짜리의 파를 넣는다고 하면,
 * 
 * 3번째 파를 자를때 이미 파닭 5개가 완성되므로, 남는 길이의 파 5만큼은 세이브해야한다. 
 * 
 * 그리고 기존 이분탐색과 다르게, start가 가능한 부분 / end가 절대 불가능한 부분이된다.
 *
 */

public class 파닭파닭 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int S,C;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		long res = solve();
		System.out.println(res);
	}
	static long solve() {
		
		Arrays.sort(arr);
		
		int start = 1;
		int end = 1000000001;
		
		while(start+1<end) {
			int mid = (start+end)/2;
			
			if(check(mid)) {
				start = mid;
//				System.out.println("start : "+start);
			}else {
				end = mid;
			}
		}
		
		// start 길이로  남은 길이 찾기
		long cnt = 0;
		long remainder = 0;
		for(int idx=0;idx<S;idx++) {
			
			int cur = arr[idx];
			cnt += cur/start;
			
			if(cnt > C) {
				remainder += (cnt-C) * start;
				return remainder;
			}
			
			remainder += cur%start;
			
		}
		return remainder;
	}
	static boolean check(int target) {
		
		long sum = 0;
		for(int idx=0;idx<S;idx++) {
			int cur = arr[idx];
			
			sum += cur/target;
			if(sum >= C)return true;
		}
		return false;
	}
	
	static void setInitVariable() throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		S = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[S];
		for(int idx=0;idx<S;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
	}

}
