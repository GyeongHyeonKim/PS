package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 구현
 *
 */

public class BACKJOON_15702 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static int[] scores;
	static List<Info> answerList = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Collections.sort(answerList);
		
		Info o = answerList.get(0);
		System.out.println(o.num+" "+o.score);
		
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		scores = new int[N+1];
		
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=1;idx<=N;idx++) {
			scores[idx] = Integer.parseInt(st.nextToken());
		}
		
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int num = Integer.parseInt(st.nextToken());
			int score = 0;
			for(int j=1;j<=N;j++) {
				char c = st.nextToken().charAt(0);
				if(c == 'O') {
					score += scores[j]; 
				}
			}
			answerList.add(new Info(num,score));
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
