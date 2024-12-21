package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 우선순위 큐 문제
 *
 */

public class 비즈마켓 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static PriorityQueue<Integer> pq;
	static int[] B;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		long res = solve();
		System.out.println(res);
	}
	static long solve() {
		
		Arrays.sort(B);
		
		long sum = 0;
		for(int idx=0;idx<M;idx++) {
			if(pq.isEmpty())return sum;
			else {
				
				int satisfaction = pq.poll();
				if(satisfaction - B[idx]  <= 0)return sum;
				else sum += (satisfaction - B[idx]);
			}
		}
		return sum;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		B = new int[M];
		st = new StringTokenizer(br.readLine().trim());
		
		pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2) {
				int comp = o1-o2;
				if(comp>0)return -1;
				else if(comp == 0)return 0;
				else return 1;
			}
		});
		for(int idx=0;idx<N;idx++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<M;idx++) {
			B[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
