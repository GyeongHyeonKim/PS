package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 해시 자료구조 활용
 *
 */
public class BACKJOON_28446 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M;
	public static void main(String[] args) throws IOException{
		setInitVariable();
	}
	static void setInitVariable() throws IOException{
		
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		
		Map<Integer,Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int command  = Integer.parseInt(st.nextToken());
			switch(command) {
				case 1:
					int number = Integer.parseInt(st.nextToken());
					int weight = Integer.parseInt(st.nextToken());
					map.put(weight,number);
					break;
				case 2:
					weight = Integer.parseInt(st.nextToken());
					sb.append(map.get(weight)+"\n");
					break;
			}
		}
		System.out.println(sb);
		
	}

}
