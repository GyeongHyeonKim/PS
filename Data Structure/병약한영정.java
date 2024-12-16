package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 해시 자료구조 활용
 *
 */
public class 병약한영정 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine().trim());		
		N = Integer.parseInt(st.nextToken());
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			// (효능,이름) 을 입력받는다.
			int effect = Integer.parseInt(st.nextToken());
			int name = Integer.parseInt(st.nextToken());
			
			map.put(effect, name);
			
		}
		st = new StringTokenizer(br.readLine().trim());
		int R =  Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int idx=0;idx<R;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int len = Integer.parseInt(st.nextToken());
			String temp = "";
			boolean flag = false;
			
			for(int j=0;j<len;j++) {
				int s = Integer.parseInt(st.nextToken());
				if(!map.containsKey(s)) {
					flag = true;
					break;
				}
				else {
					int t = map.get(s);
					temp += t+" ";
				}
			}
			if(flag) {
				sb.append("YOU DIED\n");
			}
			else sb.append(temp+"\n");
		}
		System.out.println(sb);
	}

}
