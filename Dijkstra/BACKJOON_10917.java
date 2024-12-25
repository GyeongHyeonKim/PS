package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * bfs / dijkstra
 * 
 *
 */

public class BACKJOON_10917 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static List<Integer>[] graph;
	static int[] dist;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve(1);
	}
	static void solve(int start) {
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1,int[] o2) {
				int comp = o1[1] - o2[1];
				if(comp>0)return 1;
				else if(comp == 0)return 0;
				else return  -1;
			}
			
		});
		pq.add(new int[] {start,0});
		
		while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			int curDist = cur[1];
			int curVertex = cur[0];
			
			if(dist[curVertex] < curDist)continue;
			
			for(int idx=0;idx<graph[curVertex].size();idx++) {
				
				int nextVertex = graph[curVertex].get(idx);
				int nextDist = curDist + 1;
				
				if(dist[nextVertex] > nextDist) {
					dist[nextVertex] = nextDist;
					pq.add(new int[] {nextVertex,nextDist});
				}
				
			}
			
		}
		if(dist[N] == INF) {
			System.out.println(-1);
		}else System.out.println(dist[N]);
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int idx=0;idx<=N;idx++) {
			graph[idx] = new ArrayList<>();
		}
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
		}
	}

}
