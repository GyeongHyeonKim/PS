package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 그리디 
 * 
 * 동일한 상품에 대한 가격 차이이가 큰 순서로 내림차순 정렬 후 더 싼것을 선택하기
 * 
 * 가격 차이가 별로 안나는 경우, 아무에서 골라도 괜찮지만 차이가 크면 반드시 둘 중에 더 싼 곳에서 사야한다
 * 
 * 
 *
 */

public class 행사준비 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,A,B;
	static List<Info> prices;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		Collections.sort(prices);
//		for(Info o : prices) {
//			System.out.println(o.p1+" "+o.p2);
//		}
		
		int apick = A;
		int bpick = B;
		long sum = 0;
		for(Info o : prices) {
			
			if(o.p1 > o.p2) {
				if(bpick >  0) {
					bpick--;
					sum += o.p2;
				}
				else {
					apick--;
					sum += o.p1;
				}
			}
			else if(o.p1 < o.p2){
				if(apick > 0) {
					apick--;
					sum += o.p1;
				}
				else {
					bpick--;
					sum += o.p2;
				}
			}
			else {
				if(apick > 0) {
					apick--;
				}
				else if(bpick > 0) {
					bpick--;
				}
				sum += o.p1;
			}
//			System.out.println("apick : "+apick+", bpick: "+bpick+", sum: "+sum);
		}
		System.out.println(sum);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		prices = new ArrayList<>();
		
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			prices.add(new Info(p1,p2));
		}
	}
	static class Info implements Comparable<Info> {
		
		int p1,p2;
		Info(int p1,int p2){
			this.p1 = p1;
			this.p2 = p2;
		}
		
		@Override
		public int compareTo(Info o) {
			int comp = Math.abs(this.p1 - this.p2) - Math.abs(o.p1 - o.p2);
			if(comp>0)return -1;
			else if(comp == 0)return 0;
			else return 1;
		}
		
	}

}
