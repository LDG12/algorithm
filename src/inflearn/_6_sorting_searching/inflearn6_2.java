package inflearn._6_sorting_searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class inflearn6_2 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[] arr =new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n-1; j++) {
        		if(arr[j]>arr[j+1]) {
        			int tmp = arr[j];
        			arr[j] = arr[j+1];
        			arr[j+1] = tmp;
        		}
        	}
        }
        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
}
