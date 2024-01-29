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
    static int[] arr2;
    static int head=1;
    static int tail=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if(n==0)break;
            arr = new int[n];
            for(int i=0; i<n; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            arr2 = new int[6];
            visited = new boolean[n];
            dfs(0,0);
            System.out.println();
        }
        br.close();
        bw.close();
    }
    static void dfs(int depth, int start) {
    	if(depth==6) {
    		for(int i : arr2) {
    			System.out.print(i+" ");
    		}
    		System.out.println();
    		return;
    	}
    	for(int i=start; i<n; i++) {
    		if(visited[i] == false) {
    			visited[i] = true;
    			arr2[depth] = arr[i];
    			dfs(depth+1, i);
    			visited[i] = false;
    		}
    	}
    }
}
