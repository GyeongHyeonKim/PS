package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_24511 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		int[] ds = new int[N];
		int[] cData = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			ds[idx] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			cData[idx] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		int[] iData = new int[M];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<M;idx++) {
			iData[idx] = Integer.parseInt(st.nextToken());
		}
		
		
		Deque<Integer> q = new ArrayDeque<>();
		for(int idx=0;idx<N;idx++) {
			if(ds[idx] == 0) { // 큐 인경우
				q.addFirst(cData[idx]);
			}
		}
		
		for(int idx=0;idx<M;idx++) {
			int v = iData[idx];
			q.addLast(v);
			sb.append(q.pollFirst()+" ");
		}
		System.out.println(sb.toString());
	}

}
