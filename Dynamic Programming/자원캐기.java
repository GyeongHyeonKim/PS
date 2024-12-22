package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * dp 방식과 BFS 2가지로 풀었는데 둘 다 통과가 되었다.
 * 
 * 사실 시간 복잡도상으로는, BFS의 경우 터지는게 맞는거 같다.
 * 
 * dp방식이 맞는듯
 *
 */
public class 자원캐기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static int answer;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		
//		for(int i=1;i<=300;i++) {
//			for(int j=1;j<=300;j++) {
//				if(j == 300) {
//					System.out.print(0);
//				}
//				else System.out.print(0+" ");
//			}
//			System.out.println();
//		}
		
		int answer = solve2(N,M);
		System.out.println(answer);
	}
	
	// dp방식
	static int solve2(int x,int y) {
		
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		
		if(x == 1 && y == 1) {
			return map[x][y];
		}
		
		dp[x][y] = 0;
		
		//위에서 도착하는 경우
		if(isRange(x-1,y)) {
			dp[x][y] = Math.max(dp[x][y], solve2(x-1,y)+map[x][y]);
		}
		
		//오른쪽에서 도착하는 경우
		if(isRange(x,y-1)) {
			dp[x][y] = Math.max(dp[x][y], solve2(x,y-1)+map[x][y]);
		}
		
		return dp[x][y];
	}
	static boolean isRange(int x,int y) {
		if(x<1 || x>N || y<1 || y>M)return false;
		return true;
	}
	
	// 재방문 BFS방식
	static void solve1() {
		
		int[][] visited = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(visited[i], -1);
		}
		visited[1][1] = map[1][1];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,1});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			if(x == N && y == M) {
				answer = Math.max(answer,visited[x][y]);
//				print(visited);
				continue;
			}
			
			for(int d=0;d<2;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx<1 || nx>N || ny<1 || ny>M)continue;
				else {
					if(visited[nx][ny] == -1) {
						visited[nx][ny] = visited[x][y]+map[nx][ny];
						q.add(new int[] {nx,ny});
					}
					else if(visited[nx][ny] < visited[x][y] + map[nx][ny]) {
						visited[nx][ny] = visited[x][y]+map[nx][ny];
						q.add(new int[] {nx,ny});
					}
				}
			}
			
		}
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		dp = new int[N+1][M+1];
		
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(dp[i], -1);
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	static void print(int[][] map) {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				System.out.print(map[i][j]+"  ");
			}
			System.out.println();
		}
	}

}
