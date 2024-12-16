package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * [첫번째 접근]
 * 
 *  내림차순으로 정렬한다음, 작은쪽 ->      <- 큰쪽 이런식으로 투포인터 느낌으로 이동하면서
 *  반드시 해당 위치를 다 쓴 후에 이동하도록 했다.
 *  
 *  3
 *  3 3 3 
 *  
 *  의 케이스에서, 실제 정답은 5지만, 6이 나오는 반례가 있었다.
 *  
 *  집을 다 쓸고 이동하는것보다, 집을 번갈아가면서 쓰는게 더 최적이다.
 *  
 * [두번째 접근]
 * 
 * PQ에 내림차순으로 정렬한다음, 2개를 뽑아서 쓸고 넣는 방식을 사용
 * 
 * 
 * 2
 * 2 2 2 까지는 넣어볼 생각을 했는데.. 
 * 근데 3 3 3 에서 답이 6 나오는걸 봤어도 이상하다고 생각 안했을거같다.
 * 
 *
 */

public class 눈치우기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int idx=0;idx<N;idx++) {
			q.add(arr[idx]);
		}
		
		int time = 0;
		while(!q.isEmpty() && q.size() > 1) {
			
			int first = q.poll();
			int second = q.poll();
			
			if(first > 1)q.add(first-1);
			if(second > 1)q.add(second-1);
			time++;
		}
		if(!q.isEmpty()) {
			int last = q.poll();
			time += last;			
		}
		
		if(time > 1440)time=-1;
		System.out.println(time);
		
		
	}
	static void solve2() {
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		
		int time = 0;
		while(start <= end) {
			
			if(start == end) {
				if(arr[start]>0) {
					arr[start]--;
					time++;
					
					if(arr[start] == 0)break;
					continue;
				}
			}
			
			if(arr[start] > 0 && arr[end] > 0) {
				arr[start]--;
				arr[end]--;
				if(arr[start] == 0)start++;
				if(arr[end] == 0)end--;
				time++;
			}
		}
		if(time  >= 1440) {
			System.out.println(-1);
		}else System.out.println(time);
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
