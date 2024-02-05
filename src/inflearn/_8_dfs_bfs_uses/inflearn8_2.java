package inflearn._8_dfs_bfs_uses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class inflearn8_2 {
	static int n,m,k;
	static int[] arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static Set<Integer> set;
    static boolean[] visited;
    static long max;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        for(int i=0; i<m; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        max = Integer.MIN_VALUE;
        dfs(0, 0);
        System.out.println(max);
        br.close();
        bw.close();
    }
    static void dfs(int index, int sum) {
    	if(sum>n)return;
    	if(index>=m) {
    		if(sum<=n) {
    			max = Math.max(max, sum);
    		}
    		return;
    	}
    	dfs(index+1, sum+arr[index]);
    	dfs(index+1, sum);
    }
}
