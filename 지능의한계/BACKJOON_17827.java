package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 지능이 안굴러갔다..
 * 
 * 우선 반복되는 길이를 찾아서 mod 연산을 해줘야할 것 같으니, 반복되는 길이를 구한다
 * 
 * 반복되는 구간을 찾았으면, 쉽게 계산하기위해 해당 구간을 원점으로 이동시키는데 
 * 
 * idx-V+1 만큼 이동시키면 된다.
 * 
 * 이제 여기서 k%mod 를 통해 찾은 위치를 다시 오른쪽으로 이동시켜주면 된다
 *
 */
public class BACKJOON_17827 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,V;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		arr = new int[N+1];
		for(int idx=1;idx<=N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int K = Integer.parseInt(st.nextToken());
			
			// 민달팽이
			if(V == arr[N]) {
				if(K <= N) {
					sb.append(arr[K]+"\n");
				}
				else sb.append(arr[N]+"\n");
				continue;
			}
			
			int res = solve(K);
			sb.append(res+"\n");
		}
		System.out.println(sb.toString());
	}
	static int solve(int k) {
		
		//V~N까지는 사이클이 생긴다
		if(k <= N-1) {
			return arr[k+1];
		}
		else {
			int mod = N-V+1;
			k = k-V+1;
			k = k%mod;
			k+=V;
			return arr[k];
		}
		
		
	}

}
