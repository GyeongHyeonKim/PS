package ct;

import java.util.*;
import java.io.*;

/**
 * 2차원 배열에서의 누적합 문제
 * 
 * 누적합 배열을 구할 때,
 * 1. (1,1)~(1,C) / (1,1) ~ (R,1) 은 바로 채울 수 있으므로 채운다.
 * 
 * 2. 시작지점과 현재지점을 왼쪽위,오른아래 꼭지점으로 하는 사각형의 누적합을 구하기 위해서는
 * 		2-1.현재 좌표를 (i,j)라 했을 때, 왼쪽 누적합 + 위쪽 누적합 - 대각선 누적합 + 현재좌표 를 해야한다.
 * 
 * 3. 누적합을 구했으면, 각 꼭지점에 해당하는 벙뮈의 누적합만 구해야하므로,
 * 		3-1. 적절하게 좌표를 이동하여 누적합을 제외하는데, 2번 제외되는 부분을 더해주는게 필요함
 *
 */

public class BACKJOON_16507 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R,C,Q;
	static int[][] map;
	static Rectangle[] rect;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int[][] sum = new int[R+1][C+1];
		for(int j=1;j<=C;j++) {
			sum[1][j] = sum[1][j-1]+map[1][j];
		}
		
		for(int i=2;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+map[i][j];
			}
		}
//		print(sum);
		
		StringBuilder sb = new StringBuilder();
		for(int idx=0;idx<Q;idx++) {
			Rectangle cur = rect[idx];
			
			int ans = sum[cur.r2][cur.c2] - sum[cur.r1-1][cur.c1-1] - sum[cur.r1-1][cur.c2] - sum[cur.r2][cur.c1-1]
					+ sum[cur.r1-1][cur.c1-1]*2;
			
//			System.out.println("ans : "+ans);
			
			int cnt = (cur.r2-cur.r1+1) * (cur.c2-cur.c1+1);
			
			ans  = ans/cnt;
			
			sb.append(ans+"\n");
		}
		System.out.println(sb);
		
	}
	static void print(int[][] target) {
		for(int i=0;i<=R;i++) {
			for(int j=0;j<=C;j++) {
				System.out.print(target[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];
		for(int i=1;i<=R;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=1;j<=C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rect = new Rectangle[Q];
		for(int idx=0;idx<Q;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			rect[idx] = new Rectangle(r1,c1,r2,c2);
		}
	}
	static class Rectangle{
		int r1,c1,r2,c2;
		
		Rectangle(int r1,int c1,int r2,int c2){
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
		}
	}

}
