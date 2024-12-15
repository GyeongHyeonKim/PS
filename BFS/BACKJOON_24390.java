package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 방문처리를 2차원으로 해야하는 BFS
 * 
 * 특정 시간을 조리중인 상태 / 조리중이 아닌 상태 2가지의 상태로 방문할 수 있다.
 *
 */

public class BACKJOON_24390 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int target;
	static int[] dx = {10,60,600};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
		System.out.println(answer);
	}
	static void solve() {
		
		int[][] visited = new int[3601][3];
		for(int i=0;i<=target;i++) {
			Arrays.fill(visited[i], -1);
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0});
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			int x = cur[0];
			int working = cur[1];
			
			if(x == target &&  working == 1) {
				answer = Math.min(answer, visited[x][working]);
				continue;
			}
			
			// (10초,1분,10분)
			for(int d=0;d<3;d++) {
				int nx = x+dx[d];
				if(nx > target)continue;
				else {
					if(visited[nx][working] == -1) {
						visited[nx][working] = visited[x][working] + 1;
						q.add(new int[] {nx,working,visited[nx][working]});
					}
					else if(visited[nx][working] > visited[x][working]+1){
						visited[nx][working] = visited[x][working] +  1;
						q.add(new int[] {nx,working,visited[nx][working]});
					}
				}
			}
			
			// 조리시작 버튼
			if(working == 0) { // 조리중이 아닐 때
				if(x == 0) {
					if(visited[30][1] == -1) {
						visited[30][1] = 1;
						q.add(new int[] {30,1,1});
					}
				}
				else {
					if(visited[x][1] == -1) {
						visited[x][1] = visited[x][0] + 1;
						q.add(new int[] {x,1,visited[x][1]});
					}
					else if(visited[x][1] > visited[x][0] + 1) {
						visited[x][1] = visited[x][0]+1;
						q.add(new int[] {x,1,visited[x][1]});
					}
				}
			}
			else { // 조리중인 경우
				int nx = x+30;
				if(nx > target)continue;
				else {
					if(visited[nx][working] == -1) {
						visited[nx][working] = visited[x][working]+1;
						q.add(new int[] {nx,working,visited[nx][working]});
					}
					else if(visited[nx][working] > visited[x][working]+1) {
						visited[nx][working] = visited[x][working]+1;
						q.add(new int[] {nx,working,visited[nx][working]});
					}
				}
			}			
		}
		
		
		
	}
	
	static void setInitVariable() throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		
		String[] s = st.nextToken().split(":");
		
		int minute = Integer.parseInt(s[0]);
		int seconds = Integer.parseInt(s[1]);
		
		target = minute * 60 + seconds;
	}

}
