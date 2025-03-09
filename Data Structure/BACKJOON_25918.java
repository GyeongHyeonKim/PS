package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_25918 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		String target = st.nextToken();
		
		Deque<Character> q = new ArrayDeque<>();
		int maxLen = -1;
		for(int idx=0;idx<target.length();idx++) {
			char c = target.charAt(idx);
			
			if(q.isEmpty())q.add(c);
			else {
				if(c == ')' && !q.isEmpty() && q.peekLast() == '(') {
					q.pollLast();
				}
				else if(c == '(' && !q.isEmpty() && q.peekLast() == ')') {
					q.pollLast();
				}
				else q.addLast(c);
				
				
			}
			maxLen = Math.max(maxLen, q.size());
			
		}
		if(!q.isEmpty())maxLen = -1;
		System.out.println(maxLen);
	}

}
