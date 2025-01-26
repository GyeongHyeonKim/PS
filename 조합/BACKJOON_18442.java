package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 단순 조합 백트래킹 문제
 * 
 * 1. 가능한 우체국의 위치 선정
 * 2. 거리를 계산
 * 		2-1. 우체국의 최대가 20개로 완탐가능하므로, 2중 for문을 통해 가장 가까운 우체국과의 거리를 찾는다
 * 
 *
 */
public class BACKJOON_18442 {	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V,P;
	static long L;
	static long[] arr;
	static long[] selected;
	static List<Long> answerList = new ArrayList<>();
	static long answer = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve(0,0);
		
		System.out.println(answer);
		for(int idx=0;idx<P;idx++) {
			System.out.print(answerList.get(idx)+" ");
		}
	}
	static void solve(int start,int cnt) {
		
		if(cnt == P) {
			long dist = check();
			if(dist < answer) {
				answer = dist;
				answerList.clear();
				for(int idx=0;idx<P;idx++) {
					answerList.add(selected[idx]);
				}
			}
			return;
		}
		for(int i=start;i<V;i++) {
			
			selected[cnt] = arr[i];
			solve(i+1,cnt+1);
		}
	}
	static long check() {
		
		// i번째 마을과 가장 가까운 우체국을 찾는다
		long sumDist = 0;
		for(int i=0;i<V;i++) {
			long minDist = Long.MAX_VALUE;
			for(int j=0;j<P;j++) {
				long curDist = Math.min(Math.abs(arr[i]-selected[j]),L-Math.abs(arr[i]-selected[j]));
				minDist = Math.min(minDist, curDist);
			}
			sumDist += minDist;
		}
		return sumDist;
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		
		arr = new long[V];
		selected = new long[P];
		for(int idx=0;idx<V;idx++) {
			arr[idx] = Long.parseLong(st.nextToken());
		}
		
	}

}
