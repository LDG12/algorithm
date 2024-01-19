package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class baekjoon2583 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    static int[][] arr;
    static ArrayList<Integer> list;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        list = new ArrayList<>();
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int startY = Integer.parseInt(st.nextToken());
        	int startX = Integer.parseInt(st.nextToken());
        	int endY = Integer.parseInt(st.nextToken());
        	int endX = Integer.parseInt(st.nextToken());
        	for(int j=startX; j<endX; j++) {
        		for(int k=startY; k<endY; k++) {
        			arr[j][k]=1;
        		}
        	}
        }
        int cnt=0;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(!visited[i][j]&&arr[i][j]==0) {
        			cnt++;
        			bfs(i, j, 1);
        		}
        	}
        }
        Collections.sort(list);
        System.out.println(cnt);
        for(int i : list) {
        	System.out.print(i+" ");
        }
        br.close();	
    }
    static void bfs(int x, int y, int cnt) {
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[]{x,y});
    	visited[x][y]=true;
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int nowX = now[0];
    		int nowY = now[1];
    		for(int i=0; i<4; i++) {
    			int nextX = nowX+dx[i];
    			int nextY = nowY+dy[i];
    			if(nextX<0 || nextY<0 || nextX>=m || nextY>=n) {
    				continue;
    			}
    			if(visited[nextX][nextY]==false && arr[nextX][nextY]==0) {
    				q.offer(new int[] {nextX,nextY});
    				visited[nextX][nextY]=true;
    				cnt++;
    			}
    		}
    	}
    	list.add(cnt);
    }
}
