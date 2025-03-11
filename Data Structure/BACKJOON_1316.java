package ct;

import java.util.*;
import java.io.*;
public class BACKJOON_1316 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			String cur = st.nextToken();
			boolean[] alpha = new boolean[26];
			boolean flag = true;
			char before = 'a';
			for(int j=0;j<cur.length();j++) {
				char c = cur.charAt(j);
				if(!alpha[c-'a']) {
					alpha[c-'a'] = true;
					before = c;
				}
				else {
					if(before == c)continue;
					else flag = false;
				}
			}
			if(flag)cnt++;
		}
		System.out.println(cnt);
	}

}
