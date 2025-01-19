package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 감동받은 풀이가 있다.
 * 
 * 1. 기존 이분탐색으로 접근 
 * - 그러나, ArrayList로 하던, LinkedList로 하던 결국 O(N)이 걸리는 부분이 존재하여 시간초과
 * 
 * 2. 스택과 큐를 이용한 접근
 * - T보다 작은 것들을 스택에, 큰것들을 큐에 옮긴다
 * - 스택에서 가장 큰 수를 꺼내서 T에 더하고, 큐에서 T보다 작은것들을 스택으로 옮기는 과정을 반복
 * 
 * 3. 이분탐색 + Union-Find
 * - 이미 탐색한 인덱스를 eat[idx] = true로 설정한다
 * - 특정 인덱스를 이미 탐색했다면, 탐색한 인덱스를 왼쪽의 인덱스와 묶어서 한 그룹으로 표현한다
 * 
 * - start 인덱스를 찾았는데 이미 먹은 상어라면, 해당 인덱스와 묶여진 부모를 바로 찾아가서 
 * 거기서부터 탐색하도록 한다
 *
 */

public class BACKJOON_30892 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static long T;
	static int[] arr;
	static int[] parent;
	static boolean[] eat;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
//		solve2();
		solve();
		System.out.println(T);
	}
//	static void solve2() {
//		
//		Deque<Integer> sq = new ArrayDeque<>();
//		Queue<Integer> bq = new ArrayDeque<>();
//		
//		Arrays.sort(arr);
//		for(int idx=0;idx<N;idx++) {
//			if(arr[idx] < T) {
//				sq.addLast(arr[idx]);
//			}
//			else {
//				bq.add(arr[idx]);
//			}
//		}
//		
//		for(int idx=0;idx<K;idx++) {
//			
//			if(!sq.isEmpty()) {
//				T += sq.pollLast();
//				
//				while(!bq.isEmpty()) {
//					if(bq.peek() < T) {
//						sq.addLast(bq.poll());
//					}
//					else break;
//				}
//			}
//			else break;
//		}
//	}
	
	static void solve() {
		
		Arrays.sort(arr);
		
		for(int idx=0;idx<K;idx++) {
			
			int start = -1;
			int end = N;
			
			while(start+1 < end) {
				
				int mid = (start+end)/2;
				
				if(check(mid)) {
					start = mid;
				}
				else {
					end = mid;
				}
				
			}
			
			// start가 가능한지 판단
			if(start != -1) {
				boolean flag = false;
				for(int i=start;i>=0;) {
					int root = getParent(i);
					
					if(T > arr[root] && !eat[root]) {
						T += arr[root];
						eat[root] = true;
						if(root != 0) {
							union(getParent(root-1),root);
						}
						flag = true;
						break;
					}
					i = root-1;
				}
				if(!flag)break;
			}

		}
	}
	static boolean check(int targetIdx) {
		if(arr[targetIdx] < T)return true;
		else return false;
	}
	
	static int getParent(int x) {
		if(x == parent[x])return x;
		else return parent[x] = getParent(parent[x]);
	}
	
	static boolean findParent(int a,int b) {
		a = getParent(a);
		b = getParent(b);
		if(a == b)return true;
		else return false;
	}
	
	static void union(int a,int b) {
		a = getParent(a);
		b = getParent(b);
		if(a<b)parent[b] = a;
		else parent[a] = b;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		T = Long.parseLong(st.nextToken());
		parent = new int[N];
		for(int idx=0;idx<N;idx++) {
			parent[idx] = idx;
		}
		arr = new int[N];
		eat = new boolean[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
