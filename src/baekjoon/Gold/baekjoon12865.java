package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon12865 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[i][0] = weight;
            arr[i][1] = value;
        }
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j] = dp[i-1][j];
                if(j-arr[i][0]>=0){
                    dp[i][j] = Math.max(dp[i-1][j], arr[i][1]+dp[i-1][j-arr[i][0]]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
