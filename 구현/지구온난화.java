package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 단순 사방 탐색.
 * 
 * 가장 큰 직사각형 -> (minX,maxX,minY,maxY) 를 구한다
 *
 */
public class 지구온난화 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static List<int[]> pos = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int minX = 15;
		int minY = 15;
		int maxX = -1;
		int maxY = -1;
		boolean[][] visited = new boolean[N+1][M+1];
		for(int idx=0;idx<pos.size();idx++) {
			
			int[] cur = pos.get(idx);
			
			int x = cur[0];
			int y = cur[1];
			
			if(!check(x,y)) { // 사라지지 않는 경우
				minX = Math.min(minX, x);
				maxX = Math.max(maxX, x);
				minY = Math.min(minY, y);
				maxY = Math.max(maxY, y);
				visited[x][y] = true;
			}
		}
		
		
		for(int i=minX;i<=maxX;i++) {
			for(int j=minY;j<=maxY;j++) {
				if(visited[i][j]) {
					System.out.print(map[i][j]);
				}
				else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}
	static boolean check(int x,int y) {
		
		int cnt = 0;
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<1 || nx > N || ny < 1 || ny > M) {
				cnt++;
				continue;
			}
			else {
				if(map[nx][ny] == '.')cnt++;
			}
		}
		
		if(cnt >= 3) {
			return true;
		}
		return false;
		
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			String s = st.nextToken();
			for(int j=0;j<s.length();j++) {
				map[i][j+1] = s.charAt(j);
				if(map[i][j+1] == 'X') {
					pos.add(new int[] {i,j+1});
				}
			}
			
		}
	}

}
