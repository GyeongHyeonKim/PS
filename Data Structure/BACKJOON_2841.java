package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_2841 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,P;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		Deque<Integer>[] q = new ArrayDeque[7];
		for(int idx=0;idx<=6;idx++) {
			q[idx] = new ArrayDeque<>();
		}
		
		int cnt = 0;
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int line = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			if(q[line].isEmpty()) {
				q[line].addLast(number);
				cnt++;
			}
			else {
				if(q[line].peekLast() < number) {
					cnt++;
					q[line].addLast(number);
				}
				else {
					while(!q[line].isEmpty()) {
						if(q[line].peekLast() > number) {
							cnt++;
							q[line].pollLast();
						}
						else break;
					}
					if(q[line].isEmpty()) {
						q[line].addLast(number);
						cnt++;
					}
					else if(q[line].peekLast() != number) {
						q[line].addLast(number);
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		
	}

}
