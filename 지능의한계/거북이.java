package ct;

import java.util.*;
import java.io.*;

/**
 * 구현..
 * 
 * 그냥 이동하면서 도착하는 모든 점에 대해서,
 * 
 * 모든 점을 포함하는 직사각형을 그리려면, x값의 최대최소 / y값의 최대최소를 가로 세로로 하는
 * 직사각형을 그리면 된다.
 *
 */

public class 거북이 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			
			String target = st.nextToken();
			if(target.length() == 1) {
				sb.append(0+"\n");
				continue;
			}
			int cx = 0;
			int cy = 0;
			int dir = 0;
			int minX = 0, minY = 0, maxX = 0,maxY = 0;
			for(int i=0;i<target.length();i++) {
				char c = target.charAt(i);
				if(c == 'F') {
					cx += dx[dir];
					cy += dy[dir];
				}
				else if(c == 'B') {
					int nd = getDir(c,dir);
					cx += dx[nd];
					cy += dy[nd];
				}
				else if(c == 'R' || c == 'L') {
					dir = getDir(c,dir);
				}
				
				minX = Math.min(minX,cx);
				minY = Math.min(minY,cy);
				maxX = Math.max(maxX, cx);
				maxY = Math.max(maxY, cy);
			}
			
			// 체크
			int xDiff = Math.abs(minX-maxX);
			int yDiff = Math.abs(minY-maxY);
			sb.append(xDiff * yDiff + "\n");
			
		}
		System.out.println(sb.toString());

	}
	static int getDir(char c,int curDir) {
		if(c == 'R') {
			curDir = (curDir+1)%4;
			return curDir;
		}
		if(c == 'L') {
			curDir--;
			if(curDir == -1)curDir = 3;
			return curDir;
		}
		if(c == 'B') {
			if(curDir == 0)return 2;
			if(curDir == 1)return 3;
			if(curDir == 2)return 0;
			if(curDir == 3)return 1;
		}
		
		return -1;
	}
}
