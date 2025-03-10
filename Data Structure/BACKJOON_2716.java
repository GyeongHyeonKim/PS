package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_2716 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case=1;test_case<=T;test_case++) {
			String nextLine = br.readLine().trim();
			if(nextLine.isEmpty()) {
				sb.append(1+"\n");
				continue;
			}
			st = new StringTokenizer(nextLine);
			String target = st.nextToken();
			
			int depth = 0;
			int maxDepth = 0;
			for(int idx=0;idx<target.length();idx++) {
				char c = target.charAt(idx);
				
				if(c == '[') {
					depth++;
				}
				else depth--;
				
				maxDepth = Math.max(maxDepth, depth);
			}
			sb.append((int)Math.pow(2, maxDepth)+"\n");
			
		}
		System.out.println(sb.toString());
	}

}
