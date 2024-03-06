package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1003 {
    static StringTokenizer st;
    static int n,m,k;
    static int[] arr;
    static StringBuilder sb;
    static int oneCnt, zeroCnt;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        int[] dp = new int[41];
        dp[1] = 1;
        for(int i=2; i<=40; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            if(n==0){
                sb.append("1 0\n");
                continue;
            }
            sb.append(dp[n-1]+" "+dp[n]+"\n");
        }
        System.out.print(sb.toString());
    }
}
