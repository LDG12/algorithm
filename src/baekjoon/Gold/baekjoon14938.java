package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;


public class baekjoon14938 {
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		int have;
		public Node() {};
		public Node(int index, int cost, int have) {
			this.index = index;
			this.cost = cost;
			this.have = have;
		}
		@Override
		public String toString() {
			return "Node [index=" + index + ", cost=" + cost + ", have=" + have + "]";
		}
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int n,m,k;
	static int[]arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[] visited;
    static Set<Integer> set;
    static int max,min;
    static int[] arr2;
    static int head=1;
    static int tail=0;
    static int[] dist;
    static ArrayList<Node>[]list;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n+1];
        for(int i=1; i<=n; i++) {
        	list[i] = new ArrayList<>(); 
        	arr[i] = Integer.parseInt(st.nextToken()); 
        }
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int distance = Integer.parseInt(st.nextToken());
        	list[from].add(new Node(to, distance, arr[to]));
        	list[to].add(new Node(from, distance, arr[from]));
        }
        int result=0;
        for(int i=1; i<=n; i++) {
        	dist = new int[n+1];
        	Arrays.fill(dist, Integer.MAX_VALUE);
        	dijkstra(i);
        	int sum=0;
        	for(int j=1; j<=n; j++) {
        		if(dist[j]!=Integer.MAX_VALUE && dist[j]<=m) {
        			sum+=arr[j];
        		}
        	}
        	result = Math.max(sum, result);
        }
        System.out.println(result);
        br.close();
        bw.close();
    }
    static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	dist[start]= 0;
    	pq.offer(new Node(start,0,arr[start]));
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		for(Node next : list[now.index]) {
    			int nextCost = dist[now.index]+next.cost;
    			if(dist[next.index]>nextCost) {
    				dist[next.index] = nextCost;
    				pq.offer(new Node(next.index, nextCost, arr[next.index]));
    			}
    		}
    	}
    }
}
