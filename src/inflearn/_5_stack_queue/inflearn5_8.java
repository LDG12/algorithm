package inflearn._5_stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class inflearn5_8 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Queue<int[]>q = new LinkedList<>();
        for(int i=0; i<n; i++) {
        	int priority = Integer.parseInt(st.nextToken());
        	q.offer(new int[] {(i),priority});
        }
        int cnt=0;
        while(!q.isEmpty()) {
        	int[] now = q.poll();
        	int nowIndex = now[0];
        	int nowPriority = now[1];
        	int size = q.size();
        	boolean check = false;
        	for(int i=0; i<size; i++) {
        		int[]next = q.poll();
        		int nextIndex = next[0];
        		int nextPriority = next[1];
        		if(nextPriority>nowPriority) {
        			check = true;
        		}
        		q.offer(new int[] {nextIndex, nextPriority});
        	}
        	if(check) {
        		q.offer(new int[] {nowIndex, nowPriority});
        		continue;
        	}else {
        		cnt++;
        		if(nowIndex == m) {
        			break;
        		}
        	}
        }
        System.out.println(cnt);
        br.close();
        bw.close();
    }
}
