package ct;

import java.util.*;
import java.io.*;

/**
 * 순열
 *
 */
public class 카드놓기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static int[] arr;
	static boolean[] selected;
	static Set<Long> s = new HashSet<>();
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		selected = new boolean[N];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,0,"");
		System.out.println(answer);
	}
	
	static void solve(int start,int cnt,String temp) {
		if(cnt == K) {
			
			long value = Long.parseLong(temp);
			if(!s.contains(value)) {
				s.add(value);
				answer++;
			}
			return;
		}
		for(int idx=0;idx<N;idx++) {
			if(!selected[idx]) {
				selected[idx] = true;
				solve(idx+1,cnt+1,temp+arr[idx]);
				selected[idx] = false;
			}
		}
	}

}
