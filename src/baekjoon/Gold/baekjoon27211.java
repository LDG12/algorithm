package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon27211 {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st= new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	for(int j=0; j<m; j++) {
        		arr[i][j]= Integer.parseInt(st.nextToken()); 
        	}
        }
        int cnt=0;
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(!visited[i][j] && arr[i][j]==0) {
        			cnt++;
        			bfs(i, j);
        		}
        	}
        }
        System.out.println(cnt);
        br.close();
        bw.close();
    }
    static void bfs(int startX, int startY) {
    	Queue<int[]> queue = new LinkedList<>();
    	queue.offer(new int[] {startX,startY});
    	visited[startX][startY]=true;
    	while(!queue.isEmpty()) {
    		int[] now = queue.poll();
    		int nowX = now[0];
    		int nowY = now[1];
    		for(int i=0; i<4; i++) {
    			int nextX = nowX+dx[i];
    			int nextY = nowY+dy[i];
    			if(nextX>=n) {
    				nextX-=n;
    			}
    			if(nextX<0) {
    				nextX+=n;
    			}
    			if(nextY>=m) {
    				nextY-=m;
    			}
    			if(nextY<0) {
    				nextY+=m;
    			}
    			if(!visited[nextX][nextY] && arr[nextX][nextY]==0) {
    				visited[nextX][nextY]= true;
    				queue.offer(new int[] {nextX,nextY});
    			}
    		}
    	}
    }
}
