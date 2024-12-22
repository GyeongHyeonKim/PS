package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 거꾸로 출발지점에서 도달할 수 있는 곳을 찾기
 * 
 * 단, 출발지에서 이동해야하므로, W가 아닌 S가 고장났다고 생각하고 풀기
 * 
 * or 맵을 위아래를 뒤집었다고 생각하고 W에서 오른쪽 아래로 내려간다고 생각하기
 * 
 *
 */
public class BACKJOON_28471 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static char[][] map;
	static int tx,ty;
	static int total = 0;
	static int[] dx = {-1,-1,-1,0,0,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,1};
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
		System.out.println(total);
	}
	static void solve() {
		
		boolean[][] visited = new boolean[N+1][N+1];
		visited[tx][ty] = true;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {tx,ty});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			for(int d=0;d<7;d++) {
				int nx = x +dx[d];
				int ny = y +dy[d];
				if(nx<1 || nx>N || ny<1  || ny>N || map[nx][ny] == '#' || visited[nx][ny])continue;
				else {
					if(!visited[nx][ny] && map[nx][ny] == '.') {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny});
						total++;
					}
				}
			}
			
		}
		
		
	}
	
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		map = new char[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			String s = st.nextToken();
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				map[i][j+1] = c;
				if(c == 'F') {
					tx = i;
					ty = j+1;
				}
			}
		}
	}

}
