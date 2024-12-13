package ct;

import java.util.*;
import java.io.*;

/**
 * 2^63에서 long + dp 느낌이 나서 Top-down 방식으로 접근
 * 
 * 탈출조건 : 오른쪽아래에 도달하는 경우.
 * 
 * 
 * bottom-up의 경우, (1,1)에서 시작하여 도달할 수 있는 위치에 이전 dp값을 누적하는 식으로 하면
 * 될듯?
 *
 */

public class 점프 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static long[][] dp;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		long res = solve(1,1);
//		print();
		System.out.println(res);
	}
	static long solve(int x,int y) {
		
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		if(x == N && y == N) {
			return 1;
		}
		
		// 현재 위치에서 오른쪽으로 가는 경우
		dp[x][y] = 0;
		
		int rx = x;
		int ry = y+map[x][y];
		
		if(isRange(rx,ry)) {
			dp[x][y] += solve(rx,ry);
		}
		
		// 현재 위치에서 아래쪽으로 가는 경우
		int dx = x+map[x][y];
		int dy = y;
		
		if(isRange(dx,dy)) {
			dp[x][y] += solve(dx,dy);
		}
		
		return dp[x][y];
	}
	static void print() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
	static boolean isRange(int x,int y) {
		if(x<1 || x>N || y<1 || y>N)return false;
		return true;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N =  Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		dp = new long[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(dp[i], -1);
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
