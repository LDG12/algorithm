package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon11659 {
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
		arr = new int[n+1];
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = arr[i-1]+num; 
		}
		for(int i=0; i<m; i++) {
			int sum=0;
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(arr[end]-arr[start-1]);
		}
	}
}
