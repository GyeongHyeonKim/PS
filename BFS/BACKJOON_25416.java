package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 
 * bfs 탐색 
 *
 */

public class BACKJOON_25416 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map = new int[5][5];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int sx,sy;
	static int answer = 987654321;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visited = new int[5][5];
		
		for(int i=0;i<5;i++) {
			Arrays.fill(visited[i], -1);
		}
		visited[sx][sy] = 0;
		q.add(new int[] {sx,sy});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			if(map[x][y] == 1) {
				answer = Math.min(answer, visited[x][y]);
				continue;
			}
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx<0 || nx > 4 ||  ny<0  || ny>4 || map[nx][ny] ==  -1)continue;
				else {
					if(visited[nx][ny] == -1) {
						visited[nx][ny] = visited[x][y]+1;
						q.add(new int[] {nx,ny});
					}
					else if(visited[nx][ny] > visited[x][y]+1) {
						visited[nx][ny] = visited[x][y]+1;
						q.add(new int[] {sx,sy});
					}
				}
			}
			
		}
		if(answer == 987654321)answer = -1;
		System.out.println(answer);
	}
	
	static void setInitVariable() throws IOException{
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<5;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
	}

}
