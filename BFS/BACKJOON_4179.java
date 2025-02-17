package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * BFS 구현
 * 
 * 1. 불과 사람의 방문을 따로 관리해야한다
 * - 같이 관리할 경우, 사람이 먼저 도착하고 불이 도착하려는 경우를 감지할 수 없다
 * - 방문체크를 하지 않으면 큐가 터진다..
 * 
 * 2. 사람이 먼저 이동하고 불이 도달한다고 했을 때
 * - 큐에 들어간 사람이 탐색을 시작할 때, 현 위치가 뷸에 덮혀있으면 탐색하면 안된다.
 *
 */
public class BACKJOON_4179 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R,C;
	static char[][] map;
	static int sx,sy;
	static List<int[]> fireList = new ArrayList<>();
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		boolean[][] v1 = new boolean[R+1][C+1];
		boolean[][] v2 = new boolean[R+1][C+1];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx,sy,1,0});
		
		for(int[] f : fireList) {
			q.add(new int[] {f[0],f[1],0,0});
			v2[f[0]][f[1]] = true;
		}
		
		v1[sx][sy] = true;
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int type = cur[2];
			int time = cur[3];
			
			// 탐색 시작지점이 불로 덮힌경우 시작 불가능
			if(type == 1 && map[x][y] == 'F')continue;
			
			for(int d=0;d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 1 || nx > R || ny<1 || ny > C) {
					if(type == 1) {
						System.out.println(time+1);
						return;
					}
					else continue;
				}
				
				// 사람
				if(type == 1) {
					if(!v1[nx][ny] && map[nx][ny] == '.') {
						v1[nx][ny] = true;
						map[nx][ny] = 'J';
						q.add(new int[] {nx,ny,type,time+1});
					}
				}
				// 불
				else {
					if(!v2[nx][ny] && map[nx][ny] != '#') {
						map[nx][ny] = 'F';
						v2[nx][ny] = true;
						q.add(new int[] {nx,ny,type,time});
					}
				}
				
			}
		}
		System.out.println("IMPOSSIBLE");
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R+1][C+1];
		for(int i=1;i<=R;i++) {
			st = new StringTokenizer(br.readLine().trim());
			String s = st.nextToken();
			for(int j=0;j<s.length();j++) {
				map[i][j+1] = s.charAt(j);
				if(map[i][j+1] == 'J') {
					sx = i;
					sy = j+1;
					map[i][j+1] = '.';
				}
				if(map[i][j+1] == 'F') {
					fireList.add(new int[] {i,j+1});
				}
			}
		}
	}

}
