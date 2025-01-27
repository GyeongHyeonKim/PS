package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * BFS 탐색 문제
 * 
 * (-500,-500) ~ (500,500) 의 범위를 (0,0) ~ (1000,1000) 으로 이동시켜서 해결한다
 *
 */

public class BACKJOON_6146 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int X,Y,N;
	static int sx,sy;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[1001][1001];
		visited[500][500] = true;
		q.add(new int[] {500,500,0});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			int x = cur[0];
			int y = cur[1];
			int dist = cur[2];
			if(x == X && y == Y) {
				System.out.println(dist);
				return;
			}
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx<0 || nx>1000 || ny<0 || ny>1000)continue;
				else {
					if(!visited[nx][ny] && map[nx][ny] != -1) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny,dist+1});
					}
				}
			}
		}
		
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		X += 500;
		Y += 500;
		
		map = new int[1001][1001];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			map[cx+500][cy+500] = -1;
		}
		
	}

}
