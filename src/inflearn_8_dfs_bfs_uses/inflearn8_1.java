package inflearn_8_dfs_bfs_uses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class inflearn8_1 {
	static int n,m,k;
	static int[] arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static Set<Integer> set;
    static boolean[] visited;
    static String min;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        total=0;
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	total+=arr[i];
        }
        set = new HashSet<>();
        min = "NO";
        dfs(0, 0);
        System.out.println(min);
        System.out.println(set);
        br.close();
        bw.close();
    }
    static void dfs(int start, int sum) {
    	if(sum>(total/2))return;
    	if(start>=n) {
    		if(total-sum==sum) {
    			min = "YES";
    		}
    		return;
    	}
    	dfs(start+1, sum+arr[start]);
    	dfs(start+1, sum);
    }
}
