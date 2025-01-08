package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 좀 햇갈렸던 백트래킹문제
 * 
 * 1. 정답을 맞추고 다음문제로 가거나, 틀리고 다음문제로 가는 2가지가 있다.
 * 
 * 2. 다음 문제로 갔는데, 이전의 3문제의 정답이 같은경우 백트래킹
 * 
 * 3. 모든 문제를 풀면, 점수를 보고 정답에 누적
 * 
 *
 */

public class BACKJOON_19949 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int[] selected;
	static int answer;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve(1,0);
		System.out.println(answer);
	}
	static void solve(int start,int score) {
		
		if(start > 3 && selected[start-3] == selected[start-2]
				&& selected[start-2] == selected[start-1]) {
			return;
		}		
		
		if(start == 11) {
			if(score >= 5) {
				answer++;
			}
			return;
		}
		
		for(int idx=1;idx<=5;idx++) {
			
			if(idx == arr[start]) {
				selected[start] = idx;
				solve(start+1,score+1);
			}
			else {
				selected[start] = idx;
				solve(start+1,score);
			}	
		}
		
	}

	
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		arr = new int[11];
		selected = new int[11];
		for(int idx=1;idx<=10;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
