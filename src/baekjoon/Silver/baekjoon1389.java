package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1389 {
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    static int[] dist;
    static ArrayList<Node>[] list;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	list[i] = new ArrayList<>(); 
        }
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	list[from].add(new Node(to, 0));
        	list[to].add(new Node(from, to));
        }
        int result = 0;
        int resultMin = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
        	dist = new int[n+1];
        	Arrays.fill(dist, Integer.MAX_VALUE);
        	dijkstra(i);
        	int now = 0;
        	for(int j=1; j<=n; j++) {
        		if(dist[j]!=Integer.MAX_VALUE) {
        			now+=dist[j];
        		}
        	}
        	if(now<resultMin) {
        		resultMin = now;
        		result = i;
        	}
        }
        System.out.println(result);
        br.close();
        bw.close();
    }
    static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	dist[start] = 0;
    	pq.offer(new Node(start, 0));
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		for(Node next : list[now.index]) {
    			int nextCost = now.cost+1;
    			if(dist[next.index] > nextCost) {
    				dist[next.index] = nextCost;
    				pq.offer(new Node(next.index, nextCost));
    			}
    		}
    	}
    }
}
