package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1927 {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer>queue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
        	Integer now = Integer.parseInt(br.readLine());
        	if(now==0) {
        		Integer num = queue.poll();
        		if(num==null)num=0;
        		System.out.println(num);
        	}else {
        		queue.offer(now);
        	}
        }
        br.close();
        bw.close();
    }
}
