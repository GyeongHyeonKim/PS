package ct;

import java.util.*;
import java.io.*;
import java.util.Map.*;

/**
 * 
 * 가장 빨리 끝나는 순서로 경기를 정렬하는 그리디문제
 *
 */

public class BACKJOON_7507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Map<Integer,List<Info>> map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			map = new HashMap<>();
			for(int idx=0;idx<N;idx++) {
				st = new StringTokenizer(br.readLine().trim());
				int day = Integer.parseInt(st.nextToken());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				if(!map.containsKey(day)) {
					List<Info> info = new ArrayList<>();
					info.add(new Info(start,end));
					map.put(day,info);
				}
				else {
					List<Info> info = map.get(day);
					info.add(new Info(start,end));
					map.put(day, info);
				}
			}
			
			int res = solve();
			sb.append("Scenario #"+test_case+":\n");
			sb.append(res+"\n\n");
			
		}
		System.out.println(sb.toString());
	}
	static int solve() {
		
		int cnt = 0;
		for(Entry<Integer,List<Info>> e : map.entrySet()) {
			int day = e.getKey();
			List<Info> infos = e.getValue();
			
			Collections.sort(infos);
			
			Info cur = infos.get(0);
			int lastEnd = cur.end;
			cnt++;
			for(int idx=1;idx<infos.size();idx++) {
				Info next = infos.get(idx);
				
				if(lastEnd <= next.start) {
					cnt++;
					lastEnd = next.end;
				}
			}
			
		}
		return cnt;
	}
	static class Info implements Comparable<Info>{
		int start,end;
		Info(int start,int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Info o) {
			int comp = this.end - o.end;
			if(comp > 0)return 1;
			else if(comp == 0)return 0;
			else return -1;
		}
	}


}
