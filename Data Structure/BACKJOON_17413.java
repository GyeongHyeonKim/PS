package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_17413 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{	
//		st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		Deque<Character> q = new ArrayDeque<>();
		
		String target = br.readLine().trim();
		for(int idx=0;idx<target.length();idx++) {
			char c = target.charAt(idx);
			
			if(c == '<') {
				
				if(!q.isEmpty()) {
					while(!q.isEmpty()) {
						sb.append(q.pollLast());
					}
				}
				
				char next = target.charAt(idx);
				while(next != '>') {
					sb.append(next);
					idx++;
					next = target.charAt(idx);
				}
				sb.append(next);
			}
			else if(c == ' '){
				while(!q.isEmpty()) {
					sb.append(q.pollLast());
				}
				sb.append(" ");
			}
			else {
				q.addLast(c);
			}
		}
		while(!q.isEmpty())sb.append(q.pollLast());
		System.out.println(sb.toString());
	}

}
