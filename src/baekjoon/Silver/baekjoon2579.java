package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2579 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] fx = new int[n+1];
        int[] gx = new int[n+1];
        if(n==1){
            fx[1] = arr[1];
            gx[1] = 0;
        }
        if(n==2){
            fx[1] = arr[1];
            gx[1] = 0;
            fx[2] = arr[1]+arr[2];
            gx[2] = arr[2];
        }
        if(n>=3){
            fx[1] = arr[1];
            gx[1] = 0;
            fx[2] = arr[1]+arr[2];
            gx[2] = arr[2];
            for(int i=3; i<=n; i++){
                fx[i] = gx[i-1]+arr[i];
                gx[i] = Math.max(fx[i-2]+arr[i], gx[i-2]+arr[i]);
            }
        }
        System.out.println(Math.max(gx[n],fx[n]));
        br.close();
    }
}
