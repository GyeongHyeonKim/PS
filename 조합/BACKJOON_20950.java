package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_20950 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Info[] infos;
	static Info target;
	static int answer = 987654321;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		for(int i=2;i<=Math.min(N,7);i++) {
			solve(0,0,new Info(0,0,0),i);			
		}
		System.out.println(answer);
	}
	
	static void solve(int start,int cnt,Info color,int target) {
		
		if(cnt == target) {
			calc(color,cnt);
			return;
		}
		
		for(int i=start;i<N;i++) {
			color.add(infos[i]);
			solve(i+1,cnt+1,color,target);
			color.minus(infos[i]);
		}
		
	}
	
	static void calc(Info color,int cnt) {
		
		int sum = (Math.abs(color.r/cnt - target.r)) +
				(Math.abs(color.g/cnt - target.g)) +
				(Math.abs(color.b/cnt - target.b));
		
		answer = Math.min(answer, sum);
	}
	
	
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		infos = new Info[N];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			infos[idx] = new Info(r,g,b);
		}
		st = new StringTokenizer(br.readLine().trim());
		
		int tr = Integer.parseInt(st.nextToken());
		int tg = Integer.parseInt(st.nextToken());
		int tb = Integer.parseInt(st.nextToken());
		
		target = new Info(tr,tg,tb);
	}
	
	static class Info{
		int r,g,b;
		Info(int r,int g,int b){
			this.r = r;
			this.g = g;
			this.b = b;
		}
		
		public void add(Info color) {
			this.r += color.r;
			this.g += color.g;
			this.b += color.b;
		}
		
		public void minus(Info color) {
			this.r -= color.r;
			this.g -= color.g;
			this.b -= color.b;
		}
	}

}
