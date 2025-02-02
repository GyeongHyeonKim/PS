package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 지능의 한계
 * 
 * 1. 뒤에서부터 이웃과 비교하여 arr[idx-1] > arr[idx] 인 순간을 찾는다
 * 		1-1. 그런게 없다면 -1
 * 
 * 2. idx-1과 교환할 숫자를 뒤에서부터 찾는다. arr[idx-1] > arr[j] 가 되는 j를 찾아야 함
 * 
 * 3. swap(idx-1,j) 
 * 
 * 4. 교환 후 idx-1의 뒷부분을 내림차순 정렬한다.
 * 
 * - Arrays의 내림차순 정렬을 위해 Collections.reverseOrder()가 필요한데, 이를 위해
 * 		기존 int[] 배열을 Integer[] 로 변경하여 사용하였다.
 * 
 * - List를 이용하여 특정 범위의 정렬을 하고싶은 경우, Collections.sort(list.subList(1,4)) 이런식으로 사용하면
 * 		(1~4(미포함)) 범위의 요소를 정렬할 수 있다. subList는 원본 리스트의 특정 부분을 참조하는
 * 		뷰(View)를 반환하므로, Collections.sort를 호출하면 원본 리스트도 변경이 된다.
 *
 */
public class BACKJOON_10973 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Integer[] arr;
	static boolean flag = true;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		if(flag) {
			System.out.println(-1);
			return;
		}
		solve();
	}
	
	static void solve() {
		
		if(N == 1) {
			System.out.println(-1);
			return;
		}
		if(N == 2) {
			if(arr[N-2] < arr[N-1]) {
				System.out.println(-1);
				return;
			}
			else {
				System.out.println(arr[N-1]+" "+arr[N-2]);
				return;
			}
		}
		else {
			StringBuilder sb = new StringBuilder();
			int idx;
			for(idx=N-1;idx>0;idx--) {
				if(arr[idx-1] > arr[idx])break;
			}
			
			int j = N-1;
			while(arr[idx-1] < arr[j])j--;
			
			swap(idx-1,j);
			
			Arrays.sort(arr,idx,N,Collections.reverseOrder());
			
			for(idx=0;idx<N;idx++) {
				System.out.print(arr[idx]+" ");
			}
			
		}
		
		
	}
	static void swap(int x,int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;	
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		arr = new Integer[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=0;idx<N;idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
			if(idx!=0 && arr[idx-1] > arr[idx])flag = false;
		}

		
	}

}
