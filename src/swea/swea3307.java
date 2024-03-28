package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea3307 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[n];
            dp[0] = arr[0];
            int len = 1;
            for(int i=1; i<n; i++){
                int now = arr[i];
                if(dp[len-1] < now){
                    dp[len++] = now;
                }
                else{
                    int index = binarySearch(now,len,dp);
                    dp[index] = now;
                }
            }
            System.out.println("#"+(tc+1)+" "+len);
        }
    }
    static int binarySearch(int num, int len, int[]dp){
        int start = 0;
        int end = len-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(dp[mid] < num){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return start;
    }
}
