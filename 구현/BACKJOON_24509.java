package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 지능이 낮게 풀었는데..
 * 사실 2차원 배열로 입력을 받은다음, 세로로 검사하면 끝이다.
 * 
 * 세로로 검사 시, 선택되지 않았고 점수가 가장 높은것을 찾으면 된다.
 *
 */

public class BACKJOON_24509 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	
	static List<Info> kor = new ArrayList<>();
	static List<Info> eng = new ArrayList<>();
	static List<Info> mat = new ArrayList<>();
	static List<Info> sci = new ArrayList<>();
	static Set<Integer> s = new HashSet<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Collections.sort(kor);
		Collections.sort(eng);
		Collections.sort(mat);
		Collections.sort(sci);
		
		
		StringBuilder sb = new StringBuilder();
		
		find(kor,sb);
		find(eng,sb);
		find(mat,sb);
		find(sci,sb);
		
		sb.append("\n");
		System.out.println(sb);
		
	}
	static void find(List<Info> target,StringBuilder sb) {
		
		for(Info o : target) {
//			System.out.println(o.num+" "+o.score);
			if(!s.contains(o.num)) {
				s.add(o.num);
				sb.append(o.num+" ");
				return;
			}
		}
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int num = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			kor.add(new Info(num,k));
			eng.add(new Info(num,e));
			mat.add(new Info(num,m));
			sci.add(new Info(num,s));
		}
	}
	static class Info implements Comparable<Info>{
		int num,score;
		Info(int num,int score){
			this.num = num;
			this.score = score;
		}
		
		@Override
		public int compareTo(Info o) {
			int comp = this.score - o.score;
			if(comp > 0)return -1;
			else if(comp == 0) {
				int comp2 = this.num - o.num;
				if(comp2 > 0)return 1;
				else if(comp2 == 0)return 0;
				else return -1;

			}
			else return 1;
		}
	}

}
