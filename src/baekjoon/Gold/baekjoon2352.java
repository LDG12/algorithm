package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2352 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        int len = 1;
        for(int i=1; i<n; i++){
            int now = arr[i];
            if(dp[len-1]  < now){
                dp[len++] = now;
            }
            else{
                int index = binarySearch(now, len, dp);
                dp[index] = now;
            }
        }
        System.out.println(len);
    }
    static int binarySearch(int num, int len, int[] dp){
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
