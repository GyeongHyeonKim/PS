package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 재방문 가능한 BFS
 * 
 * 
 *
 */

public class 무한부스터 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int N,M;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	public static void main(String[] args) throws IOException{

		setInitVariable();
		solve();
	}
	static void solve() {
		
		int answer = Integer.MAX_VALUE;
		int[][] visited = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(visited[i], -1);
		}
		visited[1][1] = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,1});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			if(x == N && y == M) {
				answer = Math.min(answer, visited[x][y]);
				continue;
			}
			
			int jump = map[x][y];
			
			for(int d=0;d<2;d++) {
				for(int j=1;j<=jump;j++) {
					
					int nx = x+dx[d]*j;
					int ny = y+dy[d]*j;
					if(nx<1 || nx>N || ny<1 || ny>M)continue;
					else {
						
						if(visited[nx][ny] == -1) {
							visited[nx][ny] = visited[x][y]+1;
							q.add(new int[] {nx,ny});
						}
						else if(visited[nx][ny] > visited[x][y]+1) {
							visited[nx][ny] = visited[x][y]+1;
							q.add(new int[] {nx,ny});
						}
						
					}
					
				}
			}
			
		}
		System.out.println(answer);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
