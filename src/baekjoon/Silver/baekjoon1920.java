package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1920 {
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
        m = Integer.parseInt(br.readLine());
        int[]compareArr = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++) {
        	compareArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<m; i++) {
        	int now = compareArr[i];
        	int lt = 0;
        	int rt = n-1;
        	boolean check = false;
        	while(lt<=rt) {
        		int mid = (lt+rt)/2;
        		if(arr[mid]==now) {
        			check=true;
        			break;
        		}
        		if(arr[mid]>now) {
        			rt=mid-1;
        		}
        		else {
        			lt = mid+1;
        		}
        	}
        	if(check) {
        		System.out.println(1);
        	}
        	else {
        		System.out.println(0);
        	}
        }
        br.close();
        bw.close();
    }
}
