package ct;

import java.util.*;
import java.io.*;

/**
 * - TURN 0 : 왼쪽 90도
 * - TURN 1 : 오른쪽 90도
 * - MOVE d : 해당방향 d만큼 이동
 * 
 * 
 *
 */
public class 로봇 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M,N;
	static int cx,cy;
	static int curDir = 0;
	static int[] dx = {0,1,0,-1}; // 동 남 서 북
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	public static void main(String[] args) throws IOException{
		setInitVariable();
	}
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M+1][M+1];
		for(int idx=0;idx<N;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			String com = st.nextToken();
			int dist = Integer.parseInt(st.nextToken());
			
			switch(com) {
			
				case "MOVE":
					
					int nx = cx + dist * dx[curDir];
					int ny = cy + dist * dy[curDir];
					if(nx>0 || nx < -M || ny < 0 || ny > M) {
						System.out.println(-1);
						return;
					}
					
					cx = nx;
					cy = ny;
					
//					System.out.println(cx+" "+cy);
					break;
				case "TURN":
					// 왼쪽 90도
					if(dist == 0) {
						curDir = getDir(curDir,dist);
					}
					// 오른쪽 90도
					else {
						curDir = getDir(curDir,dist);
					}
					break;
			}
			
		}
		System.out.println(Math.abs(cy)+" "+Math.abs(cx));
		
	}
	static int getDir(int d,int dir) {
		if(dir == 0) {
			if(d == 0)return 3;
			if(d == 1)return 0;
			if(d == 2)return 1;
			if(d == 3)return 2;
		}
		else {
			if(d == 0)return 1;
			if(d == 1)return 2;
			if(d == 2)return 3;
			if(d == 3)return 0;
		}
		return -1;
	}
}
