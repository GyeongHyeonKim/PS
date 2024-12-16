package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * Deque 자료구조 활용 
 *
 */
public class 카드문자열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Deque<String> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		
//		int comp = "AAA".compareTo("AAC");
//		System.out.println(comp);
		
		st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int test_case=1;test_case<=T;test_case++) {
			q.clear();
			
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			for(int idx=0;idx<N;idx++) {
				String s = st.nextToken();
				
				if(q.isEmpty()) {
					q.addLast(s);
				}
				else {
					if(q.peekFirst().compareTo(s) >= 0) {
						q.addFirst(s);
					}
					else {
						q.addLast(s);
					}
				}
			}
			for(String s : q) {
				sb.append(s);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}


}
