package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 조합문제
 * 
 * 소수의 합이 같은 수가 나올 수 있어서 중복을 제거해줘야 한다는데..
 * 이 말이 이해가 잘 안된다. 그런말이 어디있지?
 *
 */
public class BACKJOON_19699 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] arr;
	static Set<Integer> answerList = new TreeSet<>();
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,0,0);
		if(answerList.size() == 0) {
			System.out.println(-1);
		}
		else {
			for(int v:answerList) {
				System.out.print(v+" ");
			}
		}
		
	}
	static void solve(int start,int cnt,int sum) {
		if(cnt == M) {
			if(isPrime(sum)) {
				answerList.add(sum);
			}
			return;
		}
		for(int idx=start;idx<N;idx++) {
			solve(idx+1,cnt+1,sum+arr[idx]);
		}
	}
	
	static boolean isPrime(int target) {
		for(int i=2;i<=Math.sqrt(target);i++) {
			if(target%i == 0)return false;
		}
		return true;
	}

}
