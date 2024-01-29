package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon9663 {
	static int n,m,k;
    static StringTokenizer st;
    static int[]arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static boolean[][] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        max=0;
        dfs(0);
        System.out.println(max);
        br.close();
        bw.close();
    }
    static void dfs(int depth) {
    	if(depth>=n) {
    		max++;
    		return;
    	}
    	for(int i=0; i<n; i++) {
    		arr[depth] = i+1;
    		if(check(depth)) {
    			dfs(depth+1);
    		}
    	}
    }
    static boolean check(int col) {
    	for(int i=0; i<col; i++) {
    		if(arr[col]==arr[i])return false;
    		if(col-i == Math.abs(arr[col]-arr[i]))return false;
    	}
    	return true;
    }
}
