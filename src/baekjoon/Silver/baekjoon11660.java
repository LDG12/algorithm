package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

import sun.awt.image.ImageWatched.Link;

public class baekjoon11660 {
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
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		int[][] dp = new int[n+1][n+1];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken()); 
			}
		}
		for(int i=1; i<dp.length; i++) {
			dp[1][i]= dp[1][i-1]+arr[0][i-1];
		}
		for(int i=2; i<dp.length; i++) {
			for(int j=1; j<dp[i].length; j++) {
				if(j==1) {
					dp[i][j]=dp[i-1][j]+arr[i-1][j-1];
				}else {
					dp[i][j]=dp[i-1][j]+dp[i][j-1]+arr[i-1][j-1]-dp[i-1][j-1];
				}
			}
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int subX = endX - startX;
			int subY = endY - startY;
			int result = dp[endX][endY]- dp[endX][startY-1] - dp[startX-1][endY]+dp[startX-1][startY-1];
			System.out.println(result);
		}
	}
}
