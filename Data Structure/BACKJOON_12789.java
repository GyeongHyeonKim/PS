package ct;

import java.util.*;
import java.io.*;

/**
 *
 * 
 * 이동하는 경우는 2가지가 있다
 * 
 * 1. 줄 서 있는곳에서 간식으로 가는 것
 * 2. 한명씩만 서있을 수 있는 공간에서 간식받으러 가는 것
 *
 */
public class BACKJOON_12789 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	static int N;
	static int[] arr;
	static Deque<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		arr = new int[N];
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		int turn = 1;
		for(int idx=0;idx<N;idx++) {
			
			if(!q.isEmpty() && q.peekLast() == turn) {
				turn++;
				q.pollLast();
				idx--;
				continue;
			}
			
			if(arr[idx] == turn) {
				turn++;
			}
			else {
				q.addLast(arr[idx]);
			}
		}
		
		while(!q.isEmpty()) {
			if(q.peekLast() == turn) {
				q.pollLast();
				turn++;
			}
			else {
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
		
		
		
	}

}
