package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class baekjoon10282 {
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		
		public Node() {}
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
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static int[][] visited;
    static ArrayList<Node>[]list;
    static int[] in_degree;
    static StringBuilder sb; 
    static int[] dist;
    static int[][] result;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	list = new ArrayList[n+1];
        	for(int i=1; i<=n; i++) {
        		list[i]= new ArrayList<>();
        	}
        	for(int i=0; i<m; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		int cost = Integer.parseInt(st.nextToken());
        		list[to].add(new Node(from, cost));
        	}
        	dist = new int[n+1];
        	Arrays.fill(dist, Integer.MAX_VALUE);
        	max=0;
        	dijkstra(k);
        	int last=0;
        	for(int i=1; i<=n; i++) {
        		if(dist[i]!=0 && dist[i]!=Integer.MAX_VALUE) {
        			last = Math.max(last, dist[i]);
        		}
        	}
        	System.out.println(max+" "+last);
        }
        br.close();
        bw.close();
    }
    static void dijkstra(int start) {
    	PriorityQueue<Node>pq = new PriorityQueue<>();
    	dist[start]= 0;
    	pq.offer(new Node(start,0));
    	boolean[] visited = new boolean[n+1];
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		if(visited[now.index])continue;
    		visited[now.index] = true; 
    		max++;
    		for(Node next : list[now.index]) {
    			int nextCost = dist[now.index]+ next.cost;
    			if(dist[next.index]>nextCost) {
    				dist[next.index] = nextCost;
    				pq.offer(new Node(next.index, nextCost));
    			}
    		}
    	}
    }
}
