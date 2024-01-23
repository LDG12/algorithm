package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.PrimitiveIterator.OfDouble;

public class baekjoon14503 {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static boolean[][] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st= new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<m; j++) {
        		arr[i][j]= Integer.parseInt(st.nextToken()); 
        	}
        }
        max=1;
        dfs(startX, startY, direction, 1);
//        bfs(startX, startY, direction);
        System.out.println(max);
        br.close();
        bw.close();
    }
    static void bfs(int startX, int startY, int direction) {
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[] {startX,startY});
    	int cnt=1;
    	outer:while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int nowX = now[0];
    		int nowY = now[1];
    		int nextX =0;
    		int nextY=0;
    		inner:for(int i=0; i<4; i++) {
    			direction = (direction+3)%4;
    			nextX = nowX+dx[direction];
    			nextY = nowY+dy[direction];
    			if(nextX<0||nextY<0||nextX>=n||nextY>=m || arr[nextX][nextY]!=0) {
    				continue inner;
    			}
    			if(arr[nextX][nextY]==0) {
    				cnt++;
    				arr[nextX][nextY]=2;
    				q.offer(new int[] {nextX,nextY});
    				continue outer;
    			}
    		}
    		nextX = nowX-dx[direction];
    		nextY = nowY-dy[direction];
    		if(nextX<0||nextY<0||nextX>=n||nextY>=m || arr[nextX][nextY]==1) {
    			break outer;
    		}
    		q.offer(new int[] {nextX, nextY});
    		arr[nextX][nextY]=2;
    	}
    	max = cnt;
    }
    static void dfs(int startX, int startY, int direction, int cnt) {
    	arr[startX][startY]=2;
    	for(int i=0; i<4; i++) {
    		direction = (direction+3)%4;
    		int nextX = startX+dx[direction];
    		int nextY = startY+dy[direction];
    		if(nextX<0 || nextY< 0|| nextX>=n || nextY>=m || arr[nextX][nextY]!=0) {
    			continue;
    		}
    		if(arr[nextX][nextY]==0) {
    			max++;
    			dfs(nextX, nextY, direction, cnt+1);
    			return;
    		}
    	}
    	int back = (direction+2)%4;
    	int nextX = startX+dx[back];
    	int nextY = startY+dy[back];
    	if(nextX>=0 && nextY>=0 && nextX<n && nextY<m && arr[nextX][nextY]!=1) {
    		dfs(nextX, nextY, direction, cnt);
    	}
    }
}
