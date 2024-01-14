package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon2805 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Integer[] arr = new Integer[n];
        int max=0;
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	max = Math.max(max, arr[i]);
        }
        int lt=0;
        int rt=max;
        while(lt<=rt) {
			int mid = (lt+rt)/2;
			long tree=0;
			for(int i=0; i<n; i++) {
				if(arr[i]>mid) tree+= arr[i]-mid;
			}
			if(tree>=m) {
				lt = mid+1;
			}else if(tree<m) { 
				rt = mid-1;
			}
		}
        System.out.println(rt);
        br.close();
        bw.close();
    }
}
