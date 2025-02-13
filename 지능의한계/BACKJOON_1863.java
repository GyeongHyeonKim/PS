package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 뭔가 스택같긴한데 생각을 못했다.
 * 
 * 높이가 올라갈때 카운팅하느냐.. 내려갈때 카운팅 하느냐 중에 
 * 
 * 올라갈 때 카운팅하면 안되는 반례가 존재한다
 * 
 * 높이가 내려간다는것은 빌딩이 구분된다는 것이고, 카운팅을 할 수 있다.
 * 
 * 기존에 스택에 넣은 빌딩의 높이와 현재 빌딩의 높이를 비교하며, 같거나 클 때 까지 비교한다
 * 
 * 스택에 있는 가장 높은 빌딩의 높이와 현재 빌딩의 높이가 같은경우, 동일한 빌딩으로 생각하여 
 * 스택에 넣지 않는다.
 * 
 * 빌딩의 높이가 0인경우를 제외해야함에 주의한다
 *
 */
public class BACKJOON_1863 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Deque<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		int answer = 0;
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			while(!q.isEmpty() && q.peekLast() > y) {
				q.pollLast();
				answer++;
			}
			
			if(!q.isEmpty() && q.peekLast() == y)continue;
				
			q.addLast(y);
		}
		while(!q.isEmpty()) {
			int height = q.pollLast();
			if(height != 0)answer++;
		}
		
		System.out.println(answer);
	}

}
