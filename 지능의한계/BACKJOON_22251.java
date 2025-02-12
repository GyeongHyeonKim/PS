package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 총 7자리의 숫자를 비트로 표현하기 전까지는 감이 안왔다..
 * 
 * 1~N까지의 숫자를 만들 수 있는지 파악해야하는데,
 * 
 * 1. 현재 층수인 X에서 (1~N) 을 만들 수 있는지 파악해야한다.
 * 2. K자리수를 가진 숫자의 각 자리수에 대해, 비트를 비교한다
 * 
 * 
 *
 */
public class BACKJOON_22251 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K,P,X;
	static int[][] num = {
			{1,1,1,0,1,1,1},
			{0,0,1,0,0,0,1},
			{0,1,1,1,1,1,0},
			{0,1,1,1,0,1,1},
			{1,0,1,1,0,0,1},
			{1,1,0,1,0,1,1},
			{1,1,0,1,1,1,1},
			{0,1,1,0,0,0,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,0,1,1}
	};
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int res = solve();
		System.out.println(res);
	}
	static int solve() {
		
		int ans = 0;
		for(int i=1;i<=N;i++) {
			if(i == X)continue;
			
			int cnt = 0;
			int from = X;
			int to = i;
			
			for(int j=0;j<K;j++) {
				for(int k=0;k<7;k++) {
					if(num[from%10][k] != num[to%10][k])cnt++;
				}
				from /= 10;
				to /= 10;
			}
			if(cnt <= P)ans++;
		}
		return ans;
		
		
	}

}
