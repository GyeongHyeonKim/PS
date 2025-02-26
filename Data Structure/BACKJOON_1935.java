package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_1935 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static String target;
	static Map<Character,Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Deque<Double> q = new ArrayDeque<>();
		for(int idx=0;idx<target.length();idx++) {
			char c = target.charAt(idx);
			
			if(q.isEmpty()) {
				q.addLast(Double.valueOf(map.get(c)));
			}
			else {
				if(c == '*') {
					double v1 = q.pollLast();
					double v2 = q.pollLast();
					q.addLast(v1*v2);
				}
				else if(c == '+') {
					double v1 = q.pollLast();
					double v2 = q.pollLast();
					q.addLast(v1+v2);
				}
				else if(c == '-') {
					double v1 = q.pollLast();
					double v2 = q.pollLast();
					q.addLast(v2-v1);
				}
				else if(c == '/') {
					double v1 = q.pollLast();
					double v2 = q.pollLast();
					q.addLast(v2/v1);
				}
				else q.addLast(Double.valueOf(map.get(c)));
			}
		}
		double answer = q.pollLast();
		String ans = String.format("%.2f", answer);
		System.out.println(ans);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		target = st.nextToken();
		
		char start = 'A';
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int v = Integer.parseInt(st.nextToken());
			map.put(start, v);
			start++;
		}
		
		
	}

}
