package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon12891 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[]arr, oper;
	static int direction;
	static int n,m,k, max, min;
	static Stack<Character>stack; 
	static PriorityQueue<List<Integer>> pq;
	static StringTokenizer st;
	static StringBuilder sb;
	static boolean[] visited;
	static int[][] result;
	static String word;
	static Set<String>set;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		word = br.readLine();
		st = new StringTokenizer(br.readLine(), " ");
		
		arr = new int[4];
		int checkzero=0;
		for(int i=0; i<4; i++) {
			arr[i]= Integer.parseInt(st.nextToken()); 
			if(arr[i]==0)checkzero++;
		}
		int max=0;
		int[] clone = new int[4];
		if(checkzero==4) {
			System.out.println(max);
			return;
		}
		for(int i=0; i<n; i++) {
			if(i>=m) {
				char prev = word.charAt(i-m);
				int num = checkChar(prev);
				clone[num]--;
			}
			char now = word.charAt(i);
			int num = checkChar(now);
			clone[num]++;
			if(checkResult(clone)) {
				max++;
			}
		}
		System.out.println(max);
	}
	static boolean check(char now) {
		if(now =='A' || now=='C' || now=='G' || now=='T')return true;
		return false;
	}
	static char checkNum(int num) {
		char a = '\0';
		if(num==0) {
			a = 'A';
		}else if(num==1) a = 'C';
		else if(num==2) a = 'G';
		else if(num==3) a = 'T';
		return a;
	}
	static int checkChar(char now) {
		int num=0;
		if(now =='A') {
			num= 0;
		}else if(now=='C') {
			num= 1;
		}else if(now=='G') {
			num= 2;
		}else if(now=='T') {
			num= 3;
		}
		return num;
	}
	static boolean checkResult(int[] compareArr) {
		for(int i=0; i<4; i++) {
			if(arr[i]>compareArr[i])return false;
		}
		return true;
	}
}
