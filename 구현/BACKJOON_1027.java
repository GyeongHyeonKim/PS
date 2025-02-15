package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_1027 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		solve();
	}
	static void solve() {
		
		int answer = 0;
		for(int cur=0;cur<N;cur++) {
			
			// 왼쪽
			PriorityQueue<Double> lq = new PriorityQueue<>();
			for(int j=cur-1;j>=0;j--) {
				
				int xdiff = cur-j;
				int ydiff = arr[cur] - arr[j];
				
				double slope = 1.0* ydiff/xdiff;
				
				if(lq.isEmpty()) {
					lq.add(slope);
				}
				else {
					if(lq.peek() <= slope)continue;
					else lq.add(slope);
				}
				
			}
			
			// 오른쪽
			PriorityQueue<Double> rq = new PriorityQueue<>(Collections.reverseOrder());
			for(int j=cur+1;j<N;j++) {
				
				int xdiff = j-cur;
				int ydiff = arr[j] - arr[cur];
				
				double slope = 1.0*ydiff/xdiff;
				
				if(rq.isEmpty()) {
					rq.add(slope);
				}
				else {
					if(rq.peek() >= slope)continue;
					else rq.add(slope);
				}
				
			}
			
//			System.out.println("cur : "+ cur +" lq.size() : "+lq.size()+" rq.size() : "+rq.size());
			
			answer = Math.max(answer, lq.size() + rq.size());
			
		}
		System.out.println(answer);
	}
	

}
