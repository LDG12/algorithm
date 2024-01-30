package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon15666 {
	static int n,m,k;
	static int[] arr, arr2;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static Set<Integer> set;
    static int head=1;
    static int tail=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
        	arr[i]= Integer.parseInt(st.nextToken()); 
        }
        Arrays.sort(arr);
        arr2 = new int[n];
        dfs(0, 0);
        br.close();
	    bw.close();
	 }
    static void dfs(int index, int start) {
    	if(index==m) {
    		for(int i : arr2) {
    			if(i!=0) {
    				System.out.print(i+" ");
    			}
    		}
    		System.out.println();
    		return;
    	}
    	int before=0;
    	for(int i=start; i<n; i++) {
    		if(before!=arr[i]) {
    			arr2[index]= arr[i];
        		before = arr[i];
        		dfs(index+1, i);
    		}
    	}
    }
}
