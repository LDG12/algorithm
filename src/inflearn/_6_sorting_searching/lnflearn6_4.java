package inflearn._6_sorting_searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class lnflearn6_4 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cashe = new int[n];
        for(int i=0; i<m; i++) {
        	int now = arr[i];
        	boolean check = false;
        	int checkIndex=0;
        	int checkValue=0;
        	for(int j=0; j<n; j++) {
        		int store = cashe[j];
        		if(now==store) {
        			check=true;
        			checkIndex=j;
        			checkValue=store;
        			break;
        		}
        	}
        	if(check) {
        		for(int j=checkIndex; j>0; j--) {
        			cashe[j] = cashe[j-1];
        		}
        		cashe[0]=checkValue;
        	}
        	else {
        		for(int j=n-1; j>0; j--) {
        			cashe[j] = cashe[j-1];
        		}
        		cashe[0]=now;
        	}
        }
        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	sb.append(cashe[i]+" ");
        }
        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
}
