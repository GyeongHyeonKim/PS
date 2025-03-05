package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_11899 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		String target = st.nextToken();
		Deque<Character> q = new ArrayDeque<>();
		for(int idx=0;idx<target.length();idx++) {
			char c = target.charAt(idx);
			
			if(q.isEmpty()) {
				q.addLast(c);
			}
			else {
				if(c == ')') {
					if(!q.isEmpty() & q.peekLast() == '(') {
						q.pollLast();
						continue;
					}
				}
				q.addLast(c);
			}
		}
		System.out.println(q.size());
	}

}
