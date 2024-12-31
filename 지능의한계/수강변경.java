package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 생각못했던 그리디..
 * 
 * 처음에는 DFS처럼 탐색하려고 생각했었다.
 * 
 * 수강 신청한 과목들 [1,2,3,4,5,...]
 * 
 * 듣고 싶은 과목들 [1,2,3,4,5,...] 
 * 
 * 이렇게 있다고 할 때, 
 * 
 * 개별 수강 신청 과목의 수를 카운팅하고, 내가 원하는 과목이 존재하는지를 확인하면 된다.
 * 어차피 교환은 무한번 가능하기 때문에 존재하기만 하면 들을 수 있다.
 * 
 * 
 *
 */
public class 수강변경 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] have;
	public static void main(String[] args) throws IOException{
		setInitVariable();
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		have = new int[1000001];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=1;idx<=N;idx++) {
			int val = Integer.parseInt(st.nextToken());
			have[val]++;
		}
		st = new StringTokenizer(br.readLine().trim());
		int res = N;
		for(int idx=0;idx<N;idx++) {
			int target = Integer.parseInt(st.nextToken());
			
			if(have[target]>0) {
				have[target]--;
				res--;
			}
		}
		System.out.println(res);
	}

}
