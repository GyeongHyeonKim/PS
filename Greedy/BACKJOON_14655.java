package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 게시판을 보고 문제를 이해했다..
 * 
 * 길이 3인 윈도우를 이동시키는데, 마지막 원소가 배열 범위를 벗어나도 
 * 나머지는 뒤집을 수 있으며, 심지어 양 끝도 뒤집을 수 있다.
 * 
 * 뒤집는 횟수의 제한은 없으므로, 윈도우를 옮겨가면서 모든 원소를 양수 / 음수로 
 * 만들 수 있다. 
 * 
 * 따라서 그냥 절댓값의 합을 구하면 된다
 *
 */

public class BACKJOON_14655 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int sum;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		System.out.println(sum);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N =  Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			int num = Integer.parseInt(st.nextToken());
			sum += Math.abs(num);
		}
		sum *=2;
	}

}
