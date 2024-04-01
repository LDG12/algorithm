package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Solution
{
    static final int MOD = 1234567891;
    static long[] factorial = new long[1000001];
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        factorial[0] = 1;
        for(int i=1; i<=1000000; i++){
            factorial[i] = factorial[i-1] * i % MOD;
        }
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long left = factorial[n];
            long right = (factorial[n-k] * factorial[k]) % MOD;
            long result = dfs(right, MOD-2);
            sb.append("#").append(tc).append(" ");
            sb.append(left * result % MOD).append("\n");
        }
        System.out.print(sb.toString().trim());
    }
    static long dfs(long n, long k) {
        if(k == 1){
            return n;
        }
        long x = dfs(n, k/2) % MOD;
        if(k % 2 == 0){
            return x * x % MOD;
        }else{
            return ((x * x) % MOD * n) % MOD;
        }
    }

}
