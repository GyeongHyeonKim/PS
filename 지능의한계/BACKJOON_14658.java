package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 이해 불가능
 * 
 * 임의의 별을 포함하는 사각형을 그리고, 최대한 오른쪽 아래로 당긴다고 생각해보자
 * 그러면 왼쪽 세로선과 위쪽 가로선에 별이 오거나, 혹은 두 점이 일치할 수 있다
 * 
 * 모든 경우의 수인 K^2 에 대해서 두 점을 좌상단으로 하는 트램펄린의 범위를 조사해서
 * 최댓값을 찾는다..
 *
 */

public class BACKJOON_14658 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,L,K;
	static List<int[]> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int answer = 0;
		for(int i=0;i<K;i++) {
			int[] first = arr.get(i);
			for(int j=0;j<K;j++) {
				int[] second = arr.get(j);
				
				int x = first[0];
				int y = second[1];
				
				answer = Math.max(answer, Calc(x,y));
			}
		}
		System.out.println(K-answer);
	}
	static int Calc(int x,int y) {
		int cnt = 0;
		for(int k=0;k<K;k++) {
			
			int[] cur = arr.get(k);
			
			int tx = cur[0];
			int ty = cur[1];
			
			if(x <= tx && tx <= x+L && y <= ty && ty <= y+L) {
				cnt++;
			}
			
		}
		return cnt;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int idx=0;idx<K;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new int[] {x,y});
		}
		
	}

}
