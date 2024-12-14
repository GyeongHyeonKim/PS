package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_17129 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int N,M;
	static int sx,sy;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		boolean[][] visited = new boolean[N+1][M+1];
		visited[sx][sy] = true;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx,sy,0});
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int dist = cur[2];
			
			if(map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 5) {
				System.out.println("TAK");
				System.out.println(dist);
				return;
			}
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx<1 || nx>N || ny<1 || ny>M || visited[nx][ny])continue;
				else {
					if(map[nx][ny] != 1) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny,dist+1});
					}
				}
			}
			
		}
		System.out.println("NIE");
	}
	
	static void setInitVariable() throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			String s = st.nextToken();
			for(int j=0;j<M;j++) {
				char c = s.charAt(j);
				map[i][j+1] = c-'0';
				if(map[i][j+1] == 2) {
					sx = i;
					sy = j+1;
					map[i][j+1] = 0;
				}
			}
		}
		
	}

}
