package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 이분탐색 + 우선순위 큐
 * 
 * 1. 이분 탐색을 통해 가능한 최솟값을 탐색
 * 
 * 2. 우선순위 큐를 사용하여, 가능한지 판단
 * - 판단 시, 단순히 sum >= M을 넘은경우에 가능한게 아니라 그때 큐에 N개가 있어야 함에 주의
 */
public class 맥주축제 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,K;
	static List<Info> infoList = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		long res = solve();
		if(res == 2147483648L) {
			res = -1;
		}
		System.out.println(res);
	}
	static long solve() {
		
		Collections.sort(infoList);
		
		long start = -1;
		long end = (long)Math.pow(2, 31);
		
		while(start+1 < end) {
			long mid = (start+end)/2;
			
			if(check(mid)) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		return end;
		
	}
	static boolean check(long target) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		long sum = 0;
		for(int idx=0;idx<infoList.size();idx++) {
			Info cur = infoList.get(idx);
			if(cur.c > target)continue;
			else {
				if(pq.size() < N) {
					pq.add(cur.v);
					sum += cur.v;
				}
				else {
					if(pq.peek() < cur.v) {
						int diff = pq.poll();
						pq.add(cur.v);
						sum -= diff;
						sum += cur.v;
					}
				}
				
				if(pq.size() == N && sum >= M)return true;
			}
		}
		return false;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine().trim());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			infoList.add(new Info(v,c));
		}
	}
	static class Info implements Comparable<Info>{
		
		int v,c;
		Info(int v,int c){
			this.v = v;
			this.c = c;
		}
		
		@Override
		public int compareTo(Info o) {
			int comp = this.c - o.c;
			if(comp > 0)return -1;
			else if(comp == 0)return 0;
			else return 1;
		}
		
	}

}
