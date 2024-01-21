package inflearn._7_dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class inflearn7_5 {
	static int n,m,k;
	static int[] arr;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i=1; i<=n; i++) {
        	arr[i] = i;
        }
        sb = new StringBuilder();
        dfs(1);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        dfs2(1);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        dfs3(1);
        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
    static void dfs(int start) {
    	if(start>n)return;
    	sb.append(arr[start]+" ");
    	dfs(start*2);
    	dfs(start*2+1);
    }
    static void dfs2(int start) {
    	if(start>n) {
    		return;
    	}
    	else {
    		dfs2(start*2);
    		sb.append(arr[start]+" ");
        	dfs2(start*2+1);
    	}
    }
    static void dfs3(int start) {
    	if(start>n) {
    		return;
    	}
    	dfs3(start*2);
    	dfs3(start*2+1);
    	sb.append(arr[start]+" ");
    }
}
