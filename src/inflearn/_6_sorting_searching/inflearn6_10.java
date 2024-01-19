package inflearn._6_sorting_searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class inflearn6_10 {
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
        int max=0;
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);
        int lt=1;
        int rt=max;
        int cnt=0;
        while(lt<=rt) {
        	int mid = (lt+rt)/2;
        	int endPosition=arr[0];
        	int count=1;
        	for(int i=0; i<n; i++) {
        		int now = arr[i];
        		if(now-endPosition>=mid) {
        			count++;
        			endPosition=arr[i];
        		}
        	}
        	if(count>=m) {
        		cnt = mid;
        		lt = mid+1;
        	}
        	else {
        		rt = mid-1;
        	}
        }
        System.out.println(cnt);
        br.close();
        bw.close();
    }
}
