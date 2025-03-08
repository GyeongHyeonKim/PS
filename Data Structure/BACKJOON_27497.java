package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_27497 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		Deque<Character> q = new ArrayDeque<>();
		Deque<Integer> sq = new ArrayDeque<>();
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int cmd = Integer.parseInt(st.nextToken());
			switch(cmd) {
				case 1:
					String next = st.nextToken();
					char c = next.charAt(0);
					q.addLast(c);
					sq.addLast(1);
					break;
				case 2:
					next = st.nextToken();
					c = next.charAt(0);
					q.addFirst(c);
					sq.addLast(2);
					break;
				case 3:
					if(sq.isEmpty())continue;
					int sequence = sq.pollLast();
					if(sequence == 1) {
						q.pollLast();
					}
					else q.pollFirst();
					break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			sb.append(q.pollFirst());
		}
		String answer = sb.toString();
		if(answer.equals(""))sb.append(0);
		System.out.println(sb.toString());
	}

}
