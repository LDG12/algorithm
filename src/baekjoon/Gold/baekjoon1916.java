package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1916 {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Node>[]list;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
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
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(start, end);
        System.out.println(dist[end]);
        br.close();
        bw.close();
    }
    static void dijkstra(int start, int end) {
    	PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
    	dist[start]=0;
    	pq.offer(new Node(start,0));
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		if(visited[now.index]== false ) {
    			visited[now.index]= true; 
    			for(int i=0; i<list[now.index].size(); i++) {
        			Node next = list[now.index].get(i);
        			int nextCost = dist[now.index]+next.cost;
        			if(dist[next.index] <= nextCost || visited[next.index])continue;
        			dist[next.index] = nextCost;
        			pq.offer(new Node(next.index, nextCost));
        		}
    		}else {
    			continue;
    		}
    	}
    }
}
class Node{
	int index;
	int cost;
	
	public Node() {}
	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
	
}