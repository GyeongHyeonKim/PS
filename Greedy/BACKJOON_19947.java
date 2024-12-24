package ct;

import java.util.*;
import java.io.*;
import java.util.Random;

/**
 * 
 * 완탐
 * 
 * Q. x+x*0.05 와 x*1.05 차이는 뭘까??
 * 
 * 뭔가 계산과정에서 부동소수점 문제가 생기는듯.
 * 
 * 
 *
 */

public class BACKJOON_19947 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int H,Y;
	static int answer;
	public static void main(String[] args) throws IOException{
		//setInitVariable();
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		while(true) {
			
			answer = 0;
			H = random.nextInt(90001) + 10000;
			Y = random.nextInt(11);
			
//			System.out.println("H : "+H+" Y :"+Y);
		
			
			solve(Y,H);
//			System.out.println(answer);
			int ans1 = answer;
			answer = 0;
			solve2(Y,H);
			int ans2 = answer;
//			System.out.println(answer);
			
			System.out.println("ans1 : "+ans1+" ans2 :"+ans2);
			if(ans1 != ans2) {
				System.out.println("H : "+H+" Y :"+Y);
				break;
			}
		}
	}
	static void solve(int remain,int sum) {
		
		if(remain == 0) {
			answer = Math.max(answer, sum);
			return;
		}
		
		if(remain >= 5) {
//			int adder = (int)(1.0*sum*0.35);
			solve(remain-5,(int)(sum*1.35));
		}
		if(remain >= 3) {
//			int adder = (int)(1.0*sum*0.2);
			solve(remain-3,(int)(sum*1.2));
		}
		if(remain >= 1) {
//			int adder = (int)(1.0*sum*0.05);
			solve(remain-1,(int)(sum*1.05));
		}
	}
	
	static void solve2(int remain,int sum) {
		
		if(remain == 0) {
			answer = Math.max(answer, sum);
			return;
		}
		
		if(remain >= 5) {
			int adder = (int)(1.0*sum*0.35);
			solve(remain-5,sum+adder);
		}
		if(remain >= 3) {
			int adder = (int)(1.0*sum*0.2);
			solve(remain-3,sum+adder);
		}
		if(remain >= 1) {
			int adder = (int)(1.0*sum*0.05);
			solve(remain-1,sum+adder);
		}
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		H = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
	}

}
