package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon1914 {
	static int n,m,k;
	static int[][] arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static Set<Integer> set;
    static int head=1;
    static int tail=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        BigInteger num = new BigInteger("2");
        sb.append(num.pow(n).subtract(new BigInteger("1")));
        if(n<=20) {
        	sb.append("\n");
        	dfs(n, 1, 3);
        }
        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
    static void dfs(int n, int start, int end) {
    	if(n==0) {
    		return;
    	}
    	else {
    		dfs(n-1, start, 6-start-end);
    		sb.append(start).append(" ").append(end).append("\n");
    		dfs(n-1, 6-start-end, end);
    	}
    }
}
