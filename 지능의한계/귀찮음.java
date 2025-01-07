package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 오름차순 정렬 후, left * right가 최소가 되려면, 매번 왼쪽에서 잘라야한다
 *
 */
public class 귀찮음 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int total;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		long sum = 0;
		for(int idx=0;idx<N;idx++) {
			
			sum += arr[idx] * (total-arr[idx]);
			total -= arr[idx];
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
			total += arr[idx];
		}
		Arrays.sort(arr);
	}
}
