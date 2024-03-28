package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon7579 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static final int MAX = 10001;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] memory = new int[n+1];
        int[] cost = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for(int i=1; i<=n; i++){
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
            max+=cost[i];
        }
        int[][] dp = new int[n+1][max+1];
        for(int i=1; i<=n; i++){
            for(int j=0; j<dp[i].length; j++){
                if(j<cost[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], memory[i]+dp[i-1][j-cost[i]]);
                }
            }
        }
        for(int i=0; i<dp[0].length; i++){
            if(dp[n][i] >= m){
                System.out.println(i);
                System.exit(0);
            }
        }


    }
}
