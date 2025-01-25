package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 조합 문제
 * 
 * 
 */
public class BACKJOON_28447 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static int choice[];
	static int[][] map;
	static int answer = -987654321;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		choice = new int[K+1];
		map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(1,0);
		System.out.println(answer);
	}
	static void solve(int start,int cnt) {
		if(cnt == K) {
			int sum = 0;
			for(int i=0;i<cnt;i++) {
				for(int j=i;j<cnt;j++) {
					sum += map[choice[i]][choice[j]];
				}
			}
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=start;i<=N;i++) {
			choice[cnt] = i;
			solve(i+1,cnt+1);
		}
		
	}
}
