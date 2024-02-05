package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon2961 {
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
		arr = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sin = Integer.parseInt(st.nextToken());
			int ssun = Integer.parseInt(st.nextToken());
			arr[i][0] = sin;
			arr[i][1] = ssun;
		}
		min = Integer.MAX_VALUE;
		dfs(0, 1, 0, 0);
		System.out.println(min);
	}
	static void dfs(int depth, int sinSum, int ssunSum, int cnt) {
		if(depth>=n) {
			if(cnt>=1) {
				int sub = Math.abs(sinSum-ssunSum);
				min = Math.min(min, sub);
			}
			return;
		}
		dfs(depth+1, sinSum * arr[depth][0], ssunSum + arr[depth][1], cnt+1);
		dfs(depth+1, sinSum, ssunSum, cnt);
	}
}
