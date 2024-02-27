package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon17070_DP {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, k;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static int[][] pipe;
    static int max;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[n][n][3];
        dp[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (arr[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                if (i == 0) continue;
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                if (arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }
        int result = dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2];
        System.out.println(result);
        // 현재 상태가 0이면 가로, 1이면 세로, 2면 대각선

    }
}
