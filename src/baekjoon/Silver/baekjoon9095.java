package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon9095 {
	static int n,m,k;
	static StringTokenizer st;
	static int max;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			n = Integer.parseInt(br.readLine());
			int[] dp = new int[11];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for(int i=4; i<=n; i++){
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			System.out.println(dp[n]);
		}
	}
}
