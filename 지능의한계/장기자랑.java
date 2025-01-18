package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 투 포인터
 * 
 * 가장 큰 숫자 제외하고 투 포인터로 접근
 * 
 * 정렬생각하고 양쪽에서 하나씩 까지는 생각했는데, 이웃한 두 차이를 고려해야하나?
 * 라는 생각에 막힘
 * 
 * max(0,..) 에서 차이가 음수일경우 0이기 때문에, 단순 투포인터로 접근해도 된다..
 * 
 *
 */

public class 장기자랑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Arrays.sort(arr);
		
		int sum = arr[N-1];
		int left = 0;
		int right = N-2;
		
		while(left < right) {
			sum += arr[right] - arr[left];
			right--;
			left++;
		}
		System.out.println(sum);
		
		
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
	}

}
