package ct;


import java.util.*;
import java.io.*;

/**
 * 스택 문제
 * 
 * 스택의 가장 위에 있는 문자와 다르면 넣고 같으면 뺀다
 * 마지막에 스택이 비어있지 않으면 불가능
 *
 */
public class BACKJOON_3986 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			String target = st.nextToken();
			
			Deque<Character> q = new ArrayDeque<>();
			for(int j=0;j<target.length();j++) {
				char c = target.charAt(j);
				if(q.isEmpty())q.addLast(c);
				else {
					if(q.peekLast() != c) {
						q.addLast(c);
					}
					else {
						q.pollLast();
					}
				}
			}
			if(q.isEmpty())cnt++;
		}
		System.out.println(cnt);
	}

}
