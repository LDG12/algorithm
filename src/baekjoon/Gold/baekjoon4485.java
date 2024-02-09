package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class baekjoon4485 {
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
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc=1;
        while(true) {
        	n = Integer.parseInt(br.readLine());
        	if(n==0)break;
        	arr = new int[n][n];
        	for(int i=0; i<n; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j=0; j<n; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken()); 
        		}
        	}
        	int start=0;
        	visited = new int[n][n];
        	for(int i=0; i<n; i++) {
        		Arrays.fill(visited[i], Integer.MAX_VALUE);
        	}
        	bfs(0);
        	System.out.println("Problem "+tc+": "+visited[n-1][n-1]);
        	tc++;
        }
        br.close();
        bw.close();
    }
    static void bfs(int start) {
    	Queue<int[]>q = new LinkedList<>();
    	q.offer(new int[] {0,0,arr[0][0]});
    	visited[0][0]=arr[0][0];
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int nowX = now[0];
    		int nowY = now[1];
    		int nowCost = now[2];
    		for(int i=0; i<4; i++) {
    			int nextX = nowX+dx[i];
    			int nextY = nowY+dy[i];
    			if(check(nextX, nextY) && visited[nextX][nextY] > nowCost+arr[nextX][nextY]) {
    				visited[nextX][nextY] = nowCost+arr[nextX][nextY];
					q.offer(new int[] {nextX,nextY,(nowCost+arr[nextX][nextY])});
    			}
    		}
    	}
    }
    static boolean check(int x,int y) {
    	if(x>=0 && y>=0 && x<n && y<n)return true;
    	return false;
    }
}
