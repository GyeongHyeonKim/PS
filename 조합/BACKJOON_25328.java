package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 조합 경우의 수 찾기
 *
 */

public class BACKJOON_25328 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String X,Y,Z;
	static int K;
	static Map<String,Integer> map = new HashMap<>();
	static List<String> answerList = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();

		solve(X,0,0,"");
		solve(Y,0,0,"");
		solve(Z,0,0,"");
		
		
		for(Map.Entry<String,Integer> e : map.entrySet()) {
			if(e.getValue() >= 2) {
				answerList.add(e.getKey());
			}
		}
		Collections.sort(answerList);
		
		if(answerList.size() == 0) {
			System.out.println(-1);
		}
		else {
			for(String s : answerList) {
				System.out.println(s);
			}
		}
		
	}
	static void solve(String target,int start,int cnt,String temp) {
		
		if(cnt == K) {
			map.put(temp, map.getOrDefault(temp,0)+1);
			return;
		}
		for(int idx=start;idx<target.length();idx++) {
			solve(target,idx+1,cnt+1,temp+target.charAt(idx));
		}
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		X = st.nextToken();
		st = new StringTokenizer(br.readLine().trim());
		Y = st.nextToken();
		st = new StringTokenizer(br.readLine().trim());
		Z = st.nextToken();
		st = new StringTokenizer(br.readLine().trim());
		K = Integer.parseInt(st.nextToken());
	}

}
