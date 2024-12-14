package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 주의점 2가지
 * 
 * 1. 텔레포트 할 수 있는 점 x에 대해 출구가 여러개일 수 있다.
 * 
 * 2. 텔레포트는 양방향으로 가능하다
 *
 */

public class 텔레포트정거장 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int S,E;
	static int[] dx = {1,-1};
	static List<Integer> connected[];
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int answer = Integer.MAX_VALUE;
		int[] visited = new int[N+1];
		Arrays.fill(visited, -1);
		
		visited[S] = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(S);
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			
			if(x == E) {
				answer = Math.min(answer, visited[x]);
				continue;
			}
			
			// 좌우이동
			for(int d=0;d<2;d++) {
				int nx = x+dx[d];
				if(nx<1 || nx > N)continue;
				else {
					if(visited[nx] == -1) {
						visited[nx] = visited[x]+1;
						q.add(nx);
					}
					else if(visited[nx] > visited[x]+1) {
						visited[nx] = visited[x]+1;
						q.add(nx);
					}
				}
			}
			
			// 순간이동
			if(connected[x].size()!=0) {
				for(int i=0;i<connected[x].size();i++) {
					int nx = connected[x].get(i);
					if(visited[nx] == -1) {
						visited[nx] = visited[x]+1;
						q.add(nx);
					}
					else if(visited[nx] > visited[x]+1) {
						visited[nx] = visited[x]+1;
						q.add(nx);
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
		
		st = new StringTokenizer(br.readLine().trim());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		connected = new ArrayList[N+1];
		for(int idx=0;idx<=N;idx++) {
			connected[idx] = new ArrayList<>();
		}
		
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			connected[from].add(to);
			connected[to].add(from);
		}
		
	}

}
