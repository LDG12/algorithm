package baekjoon.Silver;

import static java.lang.Math.rint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon3961 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        char[][] keyboard = {{'q','w','e','r','t','y','u','i','o','p'},{'a','s','d','f','g','h','j','k','l'},{'z','x','c','v','b','n','m'}};
        for(int q=0; q<tc; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	String word = st.nextToken();
        	n = Integer.parseInt(st.nextToken());
        	String[][] arr = new String[n][2];
        	for(int i=0; i<n; i++) {
        		arr[i][0]=br.readLine();
        		arr[i][1]="0";
        	}
        	for(int i=0; i<word.length(); i++) {
        		char now = word.charAt(i);
        		ArrayList<Character>list = new ArrayList<>(); 
        		for(int j=0; j<n; j++) {
        			char next = arr[j][0].charAt(i);
        			list.add(next);
        		}
        		int startX = -1;
        		int startY = -1;
        		for(int s=0; s<n; s++) {
            		int goalX = -1;
            		int goalY = -1;
            		char compare = list.get(s);
        			outer : for(int j=0; j<3; j++) {
            			inner : for(int k=0; k<keyboard[j].length; k++) {
            				if(keyboard[j][k]==now) {
            					startX = j;
            					startY = k;
            				}
            				if(keyboard[j][k]==compare) {
            					goalX = j;
            					goalY = k;
            				}
            				if(startX!=-1 && startY!=-1 && goalX!=-1 && goalY!=-1) {
            					break outer;
            				}
            			}
            		}
        			int xResult = Math.abs(startX-goalX);
        			int yResult = Math.abs(startY-goalY);
        			arr[s][1] = String.valueOf((Integer.parseInt(arr[s][1])+(xResult+yResult)));
        		}
        	}
        	Arrays.sort(arr, new Comparator<String[]>() {
        		@Override
        		public int compare(String[] s1, String[] s2) {
        			if(Integer.parseInt(s1[1])==Integer.parseInt(s2[1])) {
        				return s1[0].compareTo(s2[0]);
        			}
        			return Integer.parseInt(s1[1])-Integer.parseInt(s2[1]);
        		}
        	});
        	for(int i=0; i<n; i++) {
        		System.out.println(arr[i][0]+" "+arr[i][1]);
        	}
        }
        br.close();
    }
}
