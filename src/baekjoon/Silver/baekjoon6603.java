package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon6603 {
	static int n,m,k;
	static int[]arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[] visited;
    static Set<Integer> set;
    static int max,min;
    static int[] arr2;
    static int head=1;
    static int tail=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        arr2 = new int[4];
        for(int i=0; i<4; i++) {
        	arr2[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
        br.close();
        bw.close();
    }
    static void dfs(int depth, int sum) {
    	if(depth>=n) {
    		max = Math.max(max, sum);
    		min = Math.min(min, sum);
    		return;
    	}
    	for(int i=0; i<4; i++) {
    		if(arr2[i]!=0) {
    			arr2[i]--;
    			if(i==0) {
    				dfs(depth+1, sum+arr[depth]);
    			}else if(i==1) {
    				dfs(depth+1, sum-arr[depth]);
    			}else if(i==2) {
    				dfs(depth+1, sum*arr[depth]);
    			}else if(i==3) {
    				dfs(depth+1, sum/arr[depth]);
    			}
    			arr2[i]++;
    		}
    	}
    }
}
