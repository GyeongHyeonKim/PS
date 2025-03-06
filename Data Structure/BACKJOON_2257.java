package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 스택에 값을 넣고 누적해나간다
 * 
 * 
 *
 */
public class BACKJOON_2257 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		String target = st.nextToken();
		
		Deque<Integer> q = new ArrayDeque<>();
		int sum = 0;
		for(int idx=0;idx<target.length();idx++) {
			char c = target.charAt(idx);
			
			if(c == '(')q.addLast(-1);
			else if(c == 'H')q.addLast(1);
			else if(c == 'C')q.addLast(12);
			else if(c == 'O')q.addLast(16);
			else if('2' <= c && c <= '9') {
				int temp = q.pollLast() * (c - '0');
				q.addLast(temp);
			}
			else if(c == ')') {
				int temp = 0;
				while(q.peekLast() != -1) {
					temp += q.pollLast();
				}
				q.pollLast();
				q.addLast(temp);
			}
		}
		while(!q.isEmpty()) {
			sum += q.pollLast();
		}
		System.out.println(sum);
	}
}
