package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon1654 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long max = 0;
        for(int i=0; i<n; i++) {
        	arr[i]= Integer.parseInt(br.readLine());
        	max = Math.max(max, arr[i]);
        }
        long lt=0;
        long rt=max+1;
        while(lt<rt) {
        	long mid = (lt+rt)/2;
        	long result=0;
        	for(int i=0; i<n; i++) {
        		int now = arr[i];
        		result+=now/mid;
        	}
        	if(result>=m) {
        		lt = mid+1;
        	}else {
        		rt = mid;
        	}
        }
        System.out.println(lt-1);
        br.close();
        bw.close();
    }
}
