package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 구현
 * 
 * 한쪽 끝에서부터 반대쪽으로 이동하면서 스택에 빌딩의 인덱스를 누적해나간다
 * 
 * 현재 빌딩의 높이가 스택에 있는 빌딩의 높이보다 낮다면, 
 * 바로 인접 빌딩 설정 + 갯수(스택의 크기) 를 설정할 수 있다
 * 
 * 그렇지않다면, 스택을 꺼내면서 높은 빌딩이 나올때까지 비교한다
 * 
 * 반대방향도 같은 로직으로 구현해준다
 *
 */

public class BACKJOON_22866 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int[] near;
	static int[] total;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Deque<Integer> q = new ArrayDeque<>();
		
		for(int i=N-1;i>=0;i--) {
			if(q.isEmpty()) {
				q.addLast(i);
			}
			else {
				while(!q.isEmpty()) {
					if(arr[i] < arr[q.peekLast()]) {
						near[i] = q.peekLast();
						total[i] = q.size();
						break;
					}			
					else q.pollLast();
				}
				q.addLast(i);	
			}
		}
		q.clear();
		
		for(int i=0;i<N;i++) {
			if(q.isEmpty()) {
				q.addLast(i);
			}
			else {
				while(!q.isEmpty()) {
					if(arr[i] < arr[q.peekLast()]) {
						
						// 기존의 가까웠던 빌딩과 거리차이 확인
						if(Math.abs(near[i] - i) >= Math.abs(q.peekLast() - i)) {
							// 거리가 같거나 기존보다 짧으면 무조건 갱신
							near[i] = q.peekLast();
						}
						total[i] += q.size();
						break;
						
					}
					else q.pollLast();
				}
				q.addLast(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(total[i]+" ");
			
			if(total[i] >= 1) {
				sb.append(near[i]+1);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		arr = new int[N];
		near = new int[N];
		total = new int[N];
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
