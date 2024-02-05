package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon2023 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[][]arr, oper;
	static int direction;
	static int n,m,k, max, min;
	static Stack<Character>stack; 
	static StringTokenizer st;
	static StringBuilder sb;
	static boolean[] visited;
	static int[][] result;
	static Set<Integer>set;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[10];
		set = new TreeSet<>();
		dfs(n, 0);
		for(int i : set) {
			System.out.println(i);
		}
	}
	static void dfs(int depth, int sum) {
		if(depth==0) {
			if(check(sum)) {
				set.add(sum);
			}
			return;
			
		}
		for(int i=0; i<10; i++) {
			int now = sum*10+i;
			if(check(now)) { // depth>0
				dfs(depth-1, now);
			}
		}
	}
	static boolean check(int sum) {
		if(sum<2)return false;
		for(int i=2; i*i<=sum; i++) {
			if(sum%i==0)return false;
		}
		return true;
	}
}
