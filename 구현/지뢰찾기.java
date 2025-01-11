package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 8방탐색만 하면 되는 단순 구현
 *
 */

public class 지뢰찾기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R,C;
	static char[][] map;
	static int[][] res;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static Queue<int[]> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		
		while(true) {
			st = new StringTokenizer(br.readLine().trim());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(R == 0 && C == 0) {
				System.out.println(sb);
				break;
			}
			else {
				map = new char[R+1][C+1];
				res = new int[R+1][C+1];
				for(int i=1;i<=R;i++) {
					Arrays.fill(res[i], -1);
					st = new StringTokenizer(br.readLine().trim());
					String s = st.nextToken();
					for(int j=0;j<C;j++) {
						map[i][j+1] = s.charAt(j);
						if(map[i][j+1] == '.')q.add(new int[] {i,j+1});
					}
				}
				
				solve();
			}
			
		}
	}
	static void solve() {
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			int cnt = 0;
			for(int d=0;d<8;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx<1 || nx > R || ny<1 || ny>C)continue;
				else {
					if(map[nx][ny] == '*')cnt++;
				}
			}
			res[x][y] = cnt;
		}
		
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				if(res[i][j] == -1) {
					sb.append("*");
				}
				else sb.append(res[i][j]);
			}
			sb.append("\n");
		}
	}

}
