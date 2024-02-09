package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class baekjoon1504 {
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
    static int[] visited;
    static ArrayList<Node>[]list;
    static int[] in_degree;
    static StringBuilder sb; 
    static int[] dist;
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
        	int cost = Integer.parseInt(st.nextToken());
        	list[from].add(new Node(to,cost));
        	list[to].add(new Node(from, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        int result=0;
        result+=dijkstra(1, v1);
        result+=dijkstra(v1, v2);
        result+=dijkstra(v2, n);
        int result2=0;
        result2+=dijkstra(1, v2);
        result2+=dijkstra(v2, v1);
        result2+=dijkstra(v1, n);
        System.out.println(result>=20000000 && result2>=20000000?-1:Math.min(result, result2));
        br.close();
        bw.close();
    }
    static int dijkstra(int start, int end) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	Arrays.fill(dist, 20000000);
    	dist[start]=0;
    	boolean[] visited = new boolean[n+1];
    	pq.offer(new Node(start, 0));
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		if(visited[now.index])continue;
    		visited[now.index]=true;
    		for(Node next : list[now.index]) {
    			int nextCost = dist[now.index]+next.cost;
    			if(dist[next.index]>nextCost && visited[next.index]==false) {
    				dist[next.index]=nextCost;
    				pq.offer(new Node(next.index, nextCost));
    			}
    		}
    	}
    	return dist[end];
    }
}
