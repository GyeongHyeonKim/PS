package ct;

import java.util.*;
import java.io.*;
/**
 * 
 * dp
 * 
 * N장을 사는 방법 : (N-1)+1 ,(N-2)+2,(N-3)+3,... 이런식으로 계산해준다.
 * 
 * 최대로 돌아봤자 O(N^2) 으로 시간안에 해결가능
 * 
 *
 */
public class BACKJOON_16194 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		dp = new int[N+1];
		Arrays.fill(dp, 987654321);
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				dp[i] = Math.min(dp[i],dp[i-j]+arr[j]);
			}
		}
		System.out.println(dp[N]);
		
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=1;idx<=N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
