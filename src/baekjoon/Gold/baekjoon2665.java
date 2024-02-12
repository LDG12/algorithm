package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class baekjoon2665 {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node() {}
		public Node(int x, int y,int cost) {
			this.x=x;
			this.y=y;
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
        n = Integer.parseInt(br.readLine());
        arr= new int[n][n];
        result = new int[n][n];
        for(int i=0; i<n; i++) {
        	Arrays.fill(result[i], Integer.MAX_VALUE);
        	String tmp = br.readLine();
        	for(int j=0; j<n; j++) {
        		arr[i][j]= tmp.charAt(j)-'0'; 
        	}
        }
        dijkstra();
        System.out.println(result[n-1][n-1]);
        br.close();
        bw.close();
    }
    static void dijkstra() {
    	PriorityQueue<Node>pq =new PriorityQueue<>();
    	result[0][0] = 0;
    	pq.offer(new Node(0,0,0));
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		for(int i=0; i<4; i++) {
    			int nextX = now.x + dx[i];
    			int nextY = now.y + dy[i];
    			if(check(nextX, nextY)) {
    				if(arr[nextX][nextY]==1 && result[nextX][nextY]> now.cost) {
    					result[nextX][nextY] = now.cost;
    					pq.offer(new Node(nextX,nextY, now.cost));
    				}else if(arr[nextX][nextY]==0 && result[nextX][nextY]>now.cost+1) {
    					result[nextX][nextY] = now.cost+1;
    					pq.offer(new Node(nextX,nextY,now.cost+1));
    				}
    			}
    		}
    	}
    }
    static boolean check(int x, int y) {
    	if(x>=0 && y>=0 && x<n && y<n)return true;
    	return false;
    }
}
