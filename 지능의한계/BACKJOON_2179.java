package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_2179 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static String[] targets;
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		targets = new String[N+1];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			targets[idx] = st.nextToken();
		}
		
		solve();
	}
	static void solve() {
		
		int maxLen = -1;
		Map<String,Integer> map = new LinkedHashMap<>();
		for(int idx=0;idx<N;idx++) {
			String cur = targets[idx];
			for(int j=0;j<cur.length();j++) {
				String part = cur.substring(0,j+1);
				int cnt = map.getOrDefault(part, 0);
				map.put(part, cnt+1);
			}
		}
		
		String maxPrefix = "";
		for(Map.Entry<String,Integer> e : map.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
			if(e.getKey().length() > maxLen) {
				if(e.getValue() > 1) {
					if(e.getKey().length() > maxLen) {
						maxLen = e.getKey().length();
						maxPrefix = e.getKey();					
					}
				}
			}
		}
		
		
		List<String> answerList = new ArrayList<>();
		for(int idx=0;idx<N;idx++) {
			if(targets[idx].length() >= maxLen && 
					targets[idx].substring(0,maxLen).equals(maxPrefix)) {
				answerList.add(targets[idx]);
			}
		}
		System.out.println(answerList.get(0));
		System.out.println(answerList.get(1));
		
	}

}
