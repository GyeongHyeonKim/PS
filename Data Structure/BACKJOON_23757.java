package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 우선순위 큐를 사용하는 자료구조 문제
 *
 */

public class BACKJOON_23757 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] arr;
	static List<Integer> brr = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int idx=0;idx<N;idx++) {
			pq.add(arr[idx]);
		}
		
		for(int idx=0;idx<M;idx++) {
			
			int need = brr.get(idx);
			if(!pq.isEmpty()) {
				int numPresent = pq.poll();
				
				if(numPresent >= need) {
					numPresent-=need;
					if(numPresent != 0)pq.add(numPresent);
				}
				else {
					System.out.println(0);
					return;
				}
			}
			else {
				System.out.println(0);
				return;
			}
			
		}
		System.out.println(1);
		
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<M;idx++) {
			brr.add(Integer.parseInt(st.nextToken()));
		}
	}

}
