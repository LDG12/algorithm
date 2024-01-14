package inflearn._6_sorting_searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class inflearn6_6 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] compareArr = arr.clone();
        sb = new StringBuilder();
        Arrays.sort(compareArr);
        for(int i=0; i<n; i++) {
        	if(arr[i]!=compareArr[i]) {
        		sb.append((i+1)+" ");
        	}
        }
        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
}
