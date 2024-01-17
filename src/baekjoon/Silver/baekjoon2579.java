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
        n= Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
        	arr[i]= Integer.parseInt(br.readLine()); 
        }
        int[] fp = new int[n+1];
        int[] hp = new int[n+1];
        if(n==1) {
        	fp[1] = arr[1];
        	hp[1] = 0;
        }
        else if(n==2) {
        	fp[1] = arr[1];
        	hp[1] = 0;
        	fp[2] = arr[1]+arr[2];
        	hp[2] = arr[2];
        }
        else {
        	fp[0] = hp[0] = 0;
        	fp[1] = arr[1];
        	hp[1] = 0;
        	fp[2] = arr[1]+arr[2];
        	hp[2] = arr[2];
        	for(int i=3; i<= n; i++) {
        		fp[i]= hp[i-1]+arr[i];
        		hp[i]= Math.max(hp[i-2]+arr[i], fp[i-2]+arr[i]); 
        	}
        }
        System.out.println(Math.max(fp[n], hp[n]));
        br.close();
    }
}
