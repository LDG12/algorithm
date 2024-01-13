package inflearn._5_stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class inflearn5_6 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
        	q.offer(i);
        }
        while(q.size()!=1) {
        	int cnt=0;
        	for(int i=0; i<m-1; i++) {
        		q.offer(q.poll());
        	}
        	q.poll();
        }
        System.out.println(q.poll());
        br.close();
        bw.close();
    }
}
