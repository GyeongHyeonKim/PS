package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 스택 활용 문제
 * 
 * 처음에는, 매 문자에 대해 (idx~idx+3) 을 조사하여 PPAP가 존재하는지 확인하는 식으로 했는데
 * 시간초과가 났다.
 * 
 * 생각해보니 그냥 스택에 순서대로 넣어가면서 스택에 4글자 이상이 들어가 있으면서 마지막에 들어간게 P인경우에만
 * 4개를 빼내서 검사해보면 되더라
 * 
 * 최악의 경우에도 1_000_000 * 8 정도일듯?
 *
 */
public class BACKJOON_16120 {	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String target;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		target = st.nextToken();
		
		Deque<Character> q = new ArrayDeque<>();
		for(int idx=0;idx<target.length();idx++) {
			char c = target.charAt(idx);
			
			q.addLast(c);
			
			if(q.size() >= 4 && c == 'P') {
				
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<4;j++) {
					sb.append(q.pollLast());
				}
				
				String temp = sb.toString();
				if(temp.equals("PAPP")) {
					temp = "P";
				}
				
				for(int j=0;j<temp.length();j++) {
					q.addLast(temp.charAt(j));
				}
			}
		}
		if(q.size() == 1 && q.peek() == 'P') {
			System.out.println("PPAP");
		}
		else System.out.println("NP");
	}

}
