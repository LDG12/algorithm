package inflearn._6_sorting_searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class inflearn6_8 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lt=0;
        int rt=n-1;
        int mid = (lt+rt)/2;
        int result=0;
        while(lt<=rt) {
        	mid = (lt+rt)/2;
        	if(arr[mid]==m) {
        		result=mid+1;
        	}
        	if(arr[mid]>m) {
        		rt=mid-1;
        	}else {
        		lt=mid+1;
        	}
        }
        System.out.println(result);
        br.close();
        bw.close();
    }
}
