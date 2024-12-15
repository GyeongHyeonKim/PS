package ct;

import java.util.*;
import java.io.*;
/**
 * 
 * 다익스트라 알고리즘으로 풀었으나, 수도1에서 출발하는 BFS로 풀어도 된다.
 *
 */
public class 그래프탐색2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,Q;
	static List<Integer>[] graph;
	static List<int[]> infos = new ArrayList<>();
	static final int INF = 987654321;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		for(int idx=0;idx<infos.size();idx++) {
			
			int[] info = infos.get(idx);
			
			int from = info[0];
			int to = info[1];
			
			graph[from].add(to);
			graph[to].add(from);
			solve(1);
		}
		System.out.println(sb);
	}
	static void solve(int start) {
		
		int[] dist = new int[N+1];
		Arrays.fill(dist,INF);
		
		dist[start] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1,int[] o2) {
				int comp = o1[1]-o2[1];
				if(comp > 0)return 1;
				else if(comp == 0)return 0;
				else return -1;
			}
			
		});
		q.add(new int[] {start,0});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			int curNode = cur[0];
			int curDist = cur[1];
			
			if(dist[curNode] < curDist)continue;
			else {
				
				for(int idx=0;idx<graph[curNode].size();idx++) {
					int next = graph[curNode].get(idx);
					
					int nextDist = curDist + 1;
					
					if(dist[next] > nextDist) {
						dist[next] = nextDist;
						q.add(new int[] {next,nextDist});
					}
					
				}
				
			}
		}
		for(int i=1;i<=N;i++) {
			if(dist[i] == INF) {
				sb.append(-1+" ");				
			}
			else sb.append(dist[i]+" ");
		}
		sb.append("\n");
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
			graph[to].add(from);
		}
		st = new StringTokenizer(br.readLine().trim());
		Q = Integer.parseInt(st.nextToken());
		
		for(int idx=0;idx<Q;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			infos.add(new int[] {from,to});
		}
		
	}

}
