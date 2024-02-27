package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @author 임동길
 * @date  2024-02-27
 * @link https://www.acmicpc.net/problem/1149
 * @keyword_solution
 * 1. DP로 해결
 * 2. 가장 큰 핵심 키워드는 이전에 사용한 색깔을 이번 차례에 사용하면 안됨
 * 3. 따라서 이번 차례에서는 이전에 사용한 1개를 제외한 남은 2개중에 하나를 선택하여 최소값을 창출
 * 4. dp[i][color1] = dp[i-1][color2]+Array[i][color+1], dp[i-1][color3]+Array[i][color+1] 의 형식으로 점화식 완성
 * @input
 * 2 <= N <= 1000
 * @output
 * 1000 * 1000을 해도 Int 범위 내
 * @time_complex
 * O(N)
 * @perf
 * 12100KB, 88ms
 */
public class baekjoon1149 {
    static int n,m,k;
    static StringTokenizer st;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1]+arr[i][0], dp[i-1][2]+arr[i][0]);
            dp[i][1] = Math.min(dp[i-1][0]+arr[i][1], dp[i-1][2]+arr[i][1]);
            dp[i][2] = Math.min(dp[i-1][0]+arr[i][2], dp[i-1][1]+arr[i][2]);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<dp.length; i++){
            min = Math.min(dp[i][0], Math.min(dp[i][1],dp[i][2]));
        }
        System.out.println(min);
    }
}
