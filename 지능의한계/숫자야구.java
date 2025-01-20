package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 완탐 생각.
 * 
 * 애초에 N이 100정도에서 완탐을 생각했으나, 숫자 하나씩 가능한지.. 불가능한지.. 판정하다가
 * 아닌것 같아서 방향을 틀었다.
 * 
 * 
 * 1. 가능한 모든 숫자를 생각한다(순열)
 * 
 * 2. 가능한지 판정한다
 * 
 * - 현재 숫자와 가능한 숫자를 비교한다
 * - 스트라이크 수가 같으면 볼의 수를 체크한다
 * - 하나라도 다르면 불가능
 * - 모든 경우에 대해서 통과하면 answer+1
 *
 */

public class 숫자야구 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static List<Info> infoList = new ArrayList<>();
	static boolean[] selected = new boolean[10];
	static int answer;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve("",0);
		System.out.println(answer);
	}
	static void solve(String tmp,int cnt) {
		
		if(cnt == 3) {
			check(tmp);
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(!selected[i]) {
				selected[i] = true;
				solve(tmp+i,cnt+1);
				selected[i] = false;
			}
		}
	}
	static void check(String target) {
		
		for(int i=0;i<N;i++) {
			Info cur = infoList.get(i);
			
			int numS = 0;
			int numB = 0;
			for(int j=0;j<3;j++) {
				if(cur.num.charAt(j) == target.charAt(j)) {
					numS++;
				}
			}
			
			if(cur.s != numS)return;
			
			// 볼 체크
			for(int j=0;j<3;j++) {
				char c = cur.num.charAt(j);
				for(int k=0;k<3;k++) {
					if(j == k)continue;
					if(c == target.charAt(k))numB++;
				}
			}
			
			if(cur.b != numB)return;
		}
		answer++;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			String num = st.nextToken();
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			infoList.add(new Info(num,s,b));
		}
		
	}
	static class Info{
		String num;
		int s,b;
		Info(String num,int s,int b){
			this.num = num;
			this.s = s;
			this.b = b;
		}
	}

}
