package inflearn._8_dfs_bfs_uses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;

public class inflearn8_5 {
	static int n,m,k;
	static Integer[]arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static Set<Integer> set;
    static boolean[] visited;
    static int min;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new Integer[n];
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        Arrays.sort(arr, Collections.reverseOrder());
        min = Integer.MAX_VALUE;
        dfs(0,m,0);
        System.out.println(min);
        br.close();
        bw.close();
    }
    static void dfs(int index, int sum, int cnt) {
    	if(index>=n) {
    		if(sum==0) {
    			min = Math.min(min, cnt);
    		}
    		return;
    	}
    	dfs(index+1, sum%arr[index], cnt+(sum/arr[index]));
    	dfs(index+1, sum, cnt);
    }
}
