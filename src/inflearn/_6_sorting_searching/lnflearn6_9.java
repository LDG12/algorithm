package inflearn._6_sorting_searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lnflearn6_9 {
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
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int result=0;
        while(lt<=rt) {
        	int mid = (lt+rt)/2;
        	int cnt=1;
        	int sum=0;
        	for(int i=0; i<n; i++) {
        		int now = arr[i];
        		if((sum+now)>mid) {
        			cnt++;
        			sum=now;
        		}
        		else {
        			sum+=now;
        		}
        	}
        	if(cnt<=m) {
        		result=mid;
        		rt = mid-1;
        	}
        	else {
        		lt=mid+1;
        	}
        }
        System.out.println(result);
        br.close();
        bw.close();
    }
}
