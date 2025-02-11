package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 다익스트라 알고리즘
 *
 */
public class BACKJOON_5972 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static List<int[]>[] graph;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve(1);
	}
	static void solve(int start) {
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1,int[] o2) {
				int comp = o1[1] - o2[1];
				if(comp>0)return 1;
				else if(comp == 0)return 0;
				else return -1;
			}
			
		});
		q.add(new int[] {start,0});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			int curPoint = cur[0];
			int d = cur[1];
			
			if(dist[curPoint] < d)continue;
			else {
				for(int idx=0;idx<graph[curPoint].size();idx++) {
					int[] nextInfo = graph[curPoint].get(idx);
					int next = nextInfo[0];
					int nextDist = d + nextInfo[1];
					
					if(dist[next] > nextDist) {
						dist[next] = nextDist;
						q.add(new int[] {next,nextDist});
					}
				}
			}
			
		}
		System.out.println(dist[N]);
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
			int dist = Integer.parseInt(st.nextToken());
			
			graph[from].add(new int[] {to,dist});
			graph[to].add(new int[] {from,dist});
			
		}
		
	}

}
