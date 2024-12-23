package ct;

import java.util.*;
import java.io.*;

/**
 * PQ를 이용한 구현
 * 
 * N-M+1 을 못봐서 인덱스 오류발생..
 *
 */

public class FindingLove {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] arr;
	static int[] rank;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		PriorityQueue<Integer> pq = new  PriorityQueue<>();
		for(int idx=0;idx<M;idx++) {
			pq.add(arr[idx]);
		}
		
		int playerIdx = M;
		int rankIdx = 0;
		Deque<Integer> tempQ = new ArrayDeque<>();
		int size = N-M+1;
		while(size > 0) {
			size--;
			
			int target = rank[rankIdx];
			for(int idx=0;idx<target-1;idx++) {
				tempQ.add(pq.poll());
			}
			
			//target 등수를 탈락시킨다
			pq.poll();
			
			//선수를 옮긴다
			while(!tempQ.isEmpty()) {
				pq.add(tempQ.poll());
			}
			
			//다음 사람을 입장시킨다
			if(playerIdx == N)break;
			pq.add(arr[playerIdx]);
			
			
			playerIdx++;
			rankIdx++;
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(!pq.isEmpty()) {
			if(cnt == M-1)break;
			sb.append(pq.poll()+" ");
			cnt++;
		}
		System.out.println(sb);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		rank = new int[N-M+1];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N-M+1;idx++) {
			rank[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
