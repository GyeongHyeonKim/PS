package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 이동을 안하는 반례가 있어서 고생한 문제
 * 
 * String line = br.readLine().trim()을 통해 한 줄을 읽어들이고
 * 
 * 이 줄이 isEmpty()인지 검사를 하고 StringTokenizer에 인수로 넘겨야한다.
 *
 */

public class 판화 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static char[][] map;
	static boolean[][] vertical;
	static boolean[][] horizontal;
	static String command;
	public static void main(String[] args) throws IOException{
		setInitVariable();
		
		solve();
	}
	static void solve() {
		
		int nx = 1;
		int ny = 1;
		
		vertical = new boolean[N+1][N+1];
		horizontal = new boolean[N+1][N+1];
		
		if(command.length() > 0) {
			
			for(int idx=0;idx<command.length();idx++) {
				
				char c = command.charAt(idx);
				
				switch(c) {
				case 'U':
					nx -=1;
					if(isRange(nx,ny)) {
						vertical[nx+1][ny] = true;
						vertical[nx][ny] = true;
					}
					else nx +=1;
					break;
				case 'D':
					nx +=1;
					if(isRange(nx,ny)) {
						vertical[nx-1][ny] = true;
						vertical[nx][ny] = true;
					}
					else nx -=1;
					break;
					
				case 'L':
					ny -=1;
					if(isRange(nx,ny)) {
						horizontal[nx][ny+1] = true;
						horizontal[nx][ny]  = true;
					}
					else ny +=1;
					break;
				case 'R':
					ny +=1;
					if(isRange(nx,ny)) {
						horizontal[nx][ny-1] = true;
						horizontal[nx][ny] = true;
					}
					else ny -=1;
					break;
				}
				
			}
		}
		// 정답 채우기
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(vertical[i][j] && horizontal[i][j])map[i][j] = 43;
				else if(vertical[i][j])map[i][j] = 124;
				else if(horizontal[i][j])map[i][j] = 45;
				else map[i][j] = 46;
				
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		
	}
	static boolean isRange(int x,int y) {
		if(x<1 || x>N  || y<1 || y>N)return false;
		return true;
	}
	
	static void setInitVariable() throws IOException{
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		map = new char[N+1][N+1];
		
		String nextLine = br.readLine().trim();
		if(nextLine.isEmpty()) {
			command = "";
			return;
		}
		else{
			st = new StringTokenizer(nextLine);
			command = st.nextToken();
		}
	}

}
