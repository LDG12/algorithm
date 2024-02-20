package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1912 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	static int[] parent;
	static int[] evenParent;
	static ArrayList<Integer>trueMan; 
	static ArrayList<Integer>[] party;
	static int max;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		int[] dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			dp[i] = arr[i]; 
		}
		dp[1] = arr[1];
		for(int i=2; i<=n; i++) {
			dp[i]= Math.max(dp[i-1]+arr[i], arr[i]);
		}
		int max=Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
