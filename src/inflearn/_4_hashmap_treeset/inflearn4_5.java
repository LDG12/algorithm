package inflearn._4_hashmap_treeset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class inflearn4_5 {
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
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
        	int sum=0;
        	for(int j=i+1; j<n; j++) {
        		for(int k=j+1; k<n; k++) {
        			sum = arr[i]+arr[j]+arr[k];
        			set.add(sum);
        		}
        	}
        }
        int cnt=0;
        int answer=-1;
        for(int i : set) {
        	if(cnt==m-1) {
        		answer = i;
        	}
        	cnt++;
        }
        System.out.println(answer);
        br.close();
        bw.close();
    }
}
