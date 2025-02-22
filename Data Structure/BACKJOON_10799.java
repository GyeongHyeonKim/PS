package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 레이저와 막대기를 구분하는게 어려웠다.
 * 
 * 레이저를 쏘면, 기존에 스택에 쌓인 수(막대기) 만큼 동시에 자른다고 생각하면 편하다.
 * 
 * 이전이 막대기인 경우에는 +1 로 판단
 *
 */
public class BACKJOON_10799 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		String target = st.nextToken();
		
		Deque<Info> q = new ArrayDeque<>();
		
		int cut = 0;
		int sum = 0;
		for(int idx=0;idx<target.length();idx++) {
			char c = target.charAt(idx);
			if(q.isEmpty()) {
				q.add(new Info(idx,c));
			}
			else {
				if(c == ')') {
					// 레이저인 경우
					if(target.charAt(idx-1) == '(') {
						q.pollLast();
						sum += q.size();
					}
					// 쇠막대기의 끝 -> 레이저를 2개쏘면 막대기가 3개가 됨
					else {
						sum++;
						q.pollLast();
					}
				}
				else{
					q.addLast(new Info(idx,c));
				}
			}
		}
		System.out.println(sum);
	}
	static class Info{
		char c;
		int idx;
		
		Info(int idx,char c){
			this.idx = idx;
			this.c = c;
		}
	}

}
