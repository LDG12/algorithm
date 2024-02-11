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

public class baekjoon13549 {
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		
		public Node() {}
		public Node(int index,int cost) {
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
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<Node>pq = new PriorityQueue<>();
        int result = Integer.MAX_VALUE;
        pq.offer(new Node(n,0));
        while(!pq.isEmpty()) {
        	Node now = pq.poll();
        	if(visited[now.index])continue;
        	visited[now.index]= true; 
        	if(now.index == m) {
        		result = Math.min(result, now.cost);
        	}
        	if(now.index*2<=100000)pq.offer(new Node(now.index*2, now.cost));
        	if(now.index+1<=100000)pq.offer(new Node(now.index+1, now.cost+1));
        	if(now.index-1<=100000 && now.index-1>=0)pq.offer(new Node(now.index-1, now.cost+1));
        }
        System.out.println(result);
        br.close();
        bw.close();
    }
    static boolean check(int now) {
    	if(now>100000 || now<0) return false;
    	return true;
    }
}
