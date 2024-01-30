package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1940 {
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
        m = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
        	arr[i]= Integer.parseInt(st.nextToken()); 
        }
        Arrays.sort(arr);
        int start=0;
		int end=n-1;
		int cnt=0;
		while(start<end) {
			int sum = arr[start]+arr[end];
			if(sum==m)cnt++;
			if(sum>=m) {
				end--;
			}
			else {
				start++;
			}
		}
		System.out.println(cnt);
        br.close();
        bw.close();
    }
}
