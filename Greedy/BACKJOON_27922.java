package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 2가지 과목을 미리 정하고 정렬기준을 다르게 해서 비교하면 된다.
 * 
 * 처음부터 입력을 받을 때 미리 합의 배열(sumAB,sumAC,sumBC) 를 만들어놓고
 * 정렬해서 값만 비교하는게 더 빠르겠다...
 *
 */
public class BACKJOON_27922 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static List<Info> infos = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		//1. (a,b)의 합으로 정렬
		Collections.sort(infos,new Comparator<Info>() {
			@Override
			public int compare(Info o1,Info o2) {
				int sum1 = o1.a+o1.b;
				int sum2 = o2.a+o2.b;
				
				int comp = sum1-sum2;
				if(comp>0)return -1;
				else if(comp == 0)return 0;
				else return 1;
			}
		});
		
		//2. 합 구하기
		int tempSum1 = 0;
		for(int idx=0;idx<K;idx++) {
			Info cur = infos.get(idx);
			
			tempSum1 += cur.a+cur.b;
		}
		
		//3. (a,c)의 합으로 정렬
		Collections.sort(infos,new Comparator<Info>() {
			@Override
			public int compare(Info o1,Info o2) {
				int sum1 = o1.a+o1.c;
				int sum2 = o2.a+o2.c;
				
				int comp = sum1-sum2;
				if(comp>0)return -1;
				else if(comp == 0)return 0;
				else return 1;
			}
		});
		//4. 합 구하기
		int tempSum2  = 0;
		for(int idx=0;idx<K;idx++) {
			Info cur = infos.get(idx);
			
			tempSum2 += cur.a+cur.c;
		}
		
		//5. (b,c)의 합으로 정렬
		Collections.sort(infos,new Comparator<Info>() {
			@Override
			public int compare(Info o1,Info o2) {
				int sum1 = o1.b+o1.c;
				int sum2 = o2.b+o2.c;
				
				int comp = sum1-sum2;
				if(comp>0)return -1;
				else if(comp == 0)return 0;
				else return 1;
			}
		});
		
		//6. 합 구하기
		int tempSum3 = 0;
		for(int idx=0;idx<K;idx++) {
			Info cur = infos.get(idx);
			
			tempSum3 += cur.b+cur.c;
		}
		int answer = Math.max(tempSum1,Math.max(tempSum2, tempSum3));
		System.out.println(answer);
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			int c =  Integer.parseInt(st.nextToken());
			infos.add(new Info(a,b,c));
		}
	}
	
	static class Info{
		int a,b,c;
		Info(int a,int b,int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

}
