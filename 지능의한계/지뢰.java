package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 그리디..
 * 
 * 처음에는 가장 긴 바이토닉 부분수열 찾는건줄 알았다.
 * 
 * 대충 양 옆과 비교해서 큰 경우 해당 지뢰를 터뜨리는게 이득이라는 판단이 선다
 * 
 * 양 옆과 비교해서 둘 보다 크다면, 반드시 터뜨려야 하고 그렇지 않다면 이웃에 의해 폭발할 것이다.
 * 
 * 따라서 첫번째와 마지막의 경우만 따로 구분해서 터뜨릴지 말지를 결정하면 된다...고 함
 *
 */
public class 지뢰 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		if(N == 1) {
			sb.append(1+"\n");
			System.out.println(sb.toString());
			return;
		}
		
		if(arr[0] >= arr[1]) {
			sb.append(1+"\n");
		}
		for(int idx=1;idx<N-1;idx++) {			
			if(arr[idx-1] <= arr[idx] && arr[idx] >= arr[idx+1]) {
				sb.append(idx+1+"\n");
			}
		}
		if(arr[N-2] <= arr[N-1]) {
			sb.append(N+"\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
