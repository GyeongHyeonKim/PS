package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 해시맵을 이용하여 탈출 시 등수를 구한다.
 * 
 * 한 차에 대해서, 뒤의 모든 차와 비교를 하면서 뒤의 차보다 앞에 있는지 확인한다
 *
 */
public class 추월 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static Map<String,Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			map.put(st.nextToken(), idx+1);
		}
		
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[idx] = map.get(st.nextToken());
		}
		
		
		int answer = 0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(arr[i] > arr[j]) {
					answer++;
					break;
				}
			}
			
		}
		System.out.println(answer);
		

	}

}
