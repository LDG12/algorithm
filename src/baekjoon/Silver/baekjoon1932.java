package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1932 {
    static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] arr;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            dp[n-1][i] = arr[n-1][i];
        }
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<i+1; j++){
                dp[i][j] = Math.max(dp[i+1][j]+arr[i][j], dp[i+1][j+1]+arr[i][j]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
