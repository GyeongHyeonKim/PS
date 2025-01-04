package ct;

import java.util.*;
import java.io.*;

/**
 * dp.
 * 
 * N-1번째 줄에서 출발하여 최상단에 도달할 수 있는 경우를 카운팅한다.
 * 
 * dp인만큼, 탈출조건을 잊지 않는게 중요.
 * 
 * top-down방식
 *
 */
public class BACKJOON_24392 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static long[][] dp;
	static int[] dx = {-1,-1,-1};
	static int[] dy = {-1,0,1};
	
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		//(N,j) 에서 출발
		long sum = 0;
		for(int j=1;j<=M;j++) {
			if(map[N][j] == 1) {
				sum += solve(N,j)%1000000007;				
			}
		}
		System.out.println(sum%1000000007);
	}
	static long solve(int x,int y) {
		
		if(x == 1)return 1;
		
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		
		for(int d=0;d<3;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<1 || nx>N || ny<1 || ny>M)continue;
			else {
				if(map[nx][ny] == 1) {
					dp[x][y] += solve(nx,ny)%1000000007;
				}
			}
		}
		
		return dp[x][y]%1000000007;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		dp = new long[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(dp[i], -1);
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
