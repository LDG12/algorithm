package baekjoon.Silver;

import static java.lang.Math.rint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon11053 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int max=0;
        for(int i=0; i<n; i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        System.out.println(max);
        br.close();
       
    }
}
