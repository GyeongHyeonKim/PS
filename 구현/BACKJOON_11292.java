package ct;

import java.util.*;
import java.io.*;

/**
 * 
 * 구현
 *
 */

public class BACKJOON_11292 {	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static List<Info> infoList;
	public static void main(String[] args) throws IOException{
		setInitVariable();
	}
	static void setInitVariable() throws IOException{
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			infoList = new ArrayList<>();
			if(N == 0) {
				System.out.println(sb);
				break;
			}
			else {
				for(int idx=0;idx<N;idx++) {
					st = new StringTokenizer(br.readLine().trim());
					String name = st.nextToken();
					double height = Double.parseDouble(st.nextToken());
					infoList.add(new Info(name,height));
					
				}
				
				Collections.sort(infoList);
				String firstName = infoList.get(0).name;
				double target = infoList.get(0).height;
				sb.append(firstName+" ");
				for(int idx=1;idx<infoList.size();idx++) {
					
					if(infoList.get(idx).height == target) {
						sb.append(infoList.get(idx).name+" ");
					}
					else {
						sb.append("\n");
						break;
					}
					
				}
				
			}
			
		}
		
	}
	static class Info implements Comparable<Info>{
		String name;
		double height;
		
		Info(String name,double height){
			this.name = name;
			this.height = height;
		}
		
		@Override
		public int compareTo(Info o) {
			int comp = Double.compare(this.height, o.height);
			
			if(comp > 0)return -1;
			else if(comp == 0)return 0;
			else return 1;
		}
	}

}
