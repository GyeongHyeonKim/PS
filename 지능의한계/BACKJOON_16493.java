package ct;

import java.util.*;
import java.io.*;

/**
 * 그리디 인 줄 알았는데, 배낭문제였다..
 * 
 * 그리디로 생각하면 뭔가 반례가 많아보였는데 배낭으로 하니 간편함
 * 
 * 그리디로 접근 가능한 배낭은, 쪼갤 수 있는 경우인데 
 * 
 * 갑자기 보석도둑 문제가 생각났다.
 * 
 * 보석도둑은 쪼갤수는 없지만, 배낭의 수가 여러개이기에 우선순위 큐로 접근이 가능한 그리디 문제였다.
 * 
 * 또한, 이분탐색으로도 접근이 가능하지만 이분탐색의 경우 삭제 과정이 추가되기에 까다롭다.
 * 
 * 이분탐색 + 삭제가 들어가는경우는 상어키우기 문제처럼, 이분탐색 + union find 테크닉이 적용될 수 
 * 있는 것 같다. 
 * 
 * 그런데 이분탐색+union Find를 적용해야하는 문제는 대부분 그리디를 사용하는 풀이(pq or 다른방식)가 존재하더라.. 
 *
 */

public class BACKJOON_16493 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static Info[] infoList;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int[][] dp = new int[M+1][N+1];
		
		for(int i=1;i<=M;i++) {
			for(int j=1;j<=N;j++) {
				// 물건을 담을 수 있다면 -> 담지않는경우와 담은경우 중 더 가치가 높은걸 선택
				if(j>=infoList[i].day) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-infoList[i].day]+infoList[i].page);
				}
				// 담을 수 없다면, 이전의 값을 선택
				else dp[i][j] = dp[i-1][j];
			}
		}
		
//		for(int i=1;i<=M;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[M][N]);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		infoList = new Info[M+1];
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			infoList[idx+1] = new Info(d,p);
		}
	}
	static class Info{
		int day,page;
		
		Info(int day,int page){
			this.day = day;
			this.page = page;
		}
		
	}

}
