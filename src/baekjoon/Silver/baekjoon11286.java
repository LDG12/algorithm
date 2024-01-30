package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon11286 {
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
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        	public int compare(Integer a1, Integer a2) {
        		if(Math.abs(a1)== Math.abs(a2)) {
        			return a1-a2;
        		}
        		return Math.abs(a1)-Math.abs(a2);
        	}
		});
        for(int i=0; i<n; i++) {
        	int now = Integer.parseInt(br.readLine());
        	if(now!=0) {
        		pq.offer(now);
        	}else {
        		if(pq.isEmpty()) {
        			System.out.println(0);
        		}else {
        			System.out.println(pq.poll());
        		}
        	}
        }
        br.close();
	    bw.close();
	 }
}
