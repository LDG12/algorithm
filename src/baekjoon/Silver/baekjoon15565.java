package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.sun.security.auth.NTDomainPrincipal;

public class baekjoon15565 {
	static int n,m,k;
    static StringTokenizer st;
    static int[]arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static boolean[][] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>list  =new ArrayList<>(); 
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) {
        	int a = Integer.parseInt(st.nextToken());
        	if(a==1)list.add(i);
        }
        int start=0;
        int end=m-1;
        int min = Integer.MAX_VALUE;
        while(end<list.size()) {
        	int sub = list.get(end)- list.get(start) +1;
        	min = Math.min(min, sub);
        	start++;
        	end++;
        }
        System.out.println(min==Integer.MAX_VALUE?"-1":min);
        br.close();
        bw.close();
    }
}
