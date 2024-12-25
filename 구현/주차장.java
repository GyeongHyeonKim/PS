package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 자료구조 + 구현
 *
 */

public class 주차장 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] prices;
	static int[] weights;
	static int[] orders;
	static int[] places;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		PriorityQueue<Integer> pq  = new PriorityQueue<>();
		Deque<Integer> waitingQ = new ArrayDeque<>();
		for(int idx=1;idx<=N;idx++) {
			pq.add(idx);
		}
		
		int sum = 0;
		for(int idx=0;idx<orders.length;idx++) {
			
			int target = orders[idx];
			if(target > 0) { // 차량이 들어오는 경우
				if(!pq.isEmpty()) { // 주차장에 공간이 있다면, 배정
					int spot = pq.poll();
					places[target] = spot; // target번 차량이 spot 공간에 주차
				}
				else {
					waitingQ.addLast(target);
				}
			}
			else { // 차량이 나가는 경우
				
				int outNum = target * -1;
				sum += prices[places[outNum]] * weights[outNum];
				
				pq.add(places[outNum]);
				if(!waitingQ.isEmpty()) {
					int curNum = waitingQ.pollFirst(); //현재 기다리는 차량번호
					
					int spot = pq.poll();
					places[curNum] = spot;
				}
				
			}
			
			
		}
		System.out.println(sum);
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		places = new int[M+1];
		prices = new int[N+1];
		weights = new int[M+1];
		
		for(int idx=1;idx<=N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			prices[idx] = Integer.parseInt(st.nextToken());
		}
		for(int idx=1;idx<=M;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			weights[idx] = Integer.parseInt(st.nextToken());
		}
		orders = new int[2*M];
		for(int idx=0;idx<2*M;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			orders[idx] = Integer.parseInt(st.nextToken());
		}
	}
	
}
