package ct;

import java.util.*;
import java.io.*;

public class BACKJOON_13144 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		arr = new int[N];
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		long res = solve();
		System.out.println(res);
	}
	static long solve() {
		
		
		long ans = 0;
		int end = 0;
		boolean[] visited = new boolean[100001];
		for(int start=0;start<N;start++) {
			while(end < N) {
				if(visited[arr[end]])break;
				visited[arr[end++]] = true;
			}
			ans += end-start;
			visited[arr[start]] = false;
		}
		return ans;
	}

}
