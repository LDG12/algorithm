package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1010 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] dp;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dp = new int[30][30];
            for(int i=0; i<30; i++){
                dp[i][i] = 1;
                dp[i][0] = 1;
            }
            for(int i=2; i<30; i++){
                for(int j=1; j<= i; j++){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
            System.out.println(dp[m][n]);
        }
    }
}
