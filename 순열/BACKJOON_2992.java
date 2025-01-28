package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 완탐 순열
 * 
 * 
 *
 */

public class BACKJOON_2992 {
	
	static Scanner sc;
	static int[] arr;
	static int len;
	static boolean[] selected;
	static List<Integer> answerList = new ArrayList<>();
	static Deque<String> q = new ArrayDeque<>();
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String target = sc.nextLine();
		
		len = target.length();
		arr = new int[len];
		selected = new boolean[len];
		for(int idx=0;idx<len;idx++) {
			char c = target.charAt(idx);
			arr[idx] = c-'0';
		}
		
		solve(0,0);
		
		Collections.sort(answerList);
		int targetNum = Integer.parseInt(target);
		for(int idx=0;idx<answerList.size();idx++) {
			int cur = answerList.get(idx);
			if(targetNum < cur) {
				System.out.println(cur);
				return;
			}
		}
		System.out.println(0);
	}
	
	static void solve(int start,int cnt) {
		if(cnt == len) {
			String temp = "";
			for(String v : q) {
				temp += v;
			}
			answerList.add(Integer.parseInt(temp));
			return;
		}
		for(int i=0;i<len;i++) {
			if(!selected[i]) {
				selected[i] = true;
				q.addLast(arr[i]+"");
				solve(i+1,cnt+1);
				q.pollLast();
				selected[i] = false;
			}
		}
	}

}
