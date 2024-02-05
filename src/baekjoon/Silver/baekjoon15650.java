package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon15650 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[]arr, oper;
	static int direction;
	static int n,m,k, max, min;
	static Stack<Character>stack; 
	static StringTokenizer st;
	static StringBuilder sb;
	static boolean[] visited;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		oper=new int[n];
		for(int i=0; i<n; i++) {
			oper[i]=i+1;
		}
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		dfs(0, 0);
	}
	static void dfs(int depth, int start) {
		if(depth==m) {
			for(int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<n; i++) {
			arr[depth]= oper[i];
			dfs(depth+1, i+1);
		}
	}
}
