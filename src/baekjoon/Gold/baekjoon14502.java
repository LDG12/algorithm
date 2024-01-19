package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon14502 {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
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
        arr = new int[n][m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	for(int j=0; j<m; j++) {
        		arr[i][j]= Integer.parseInt(st.nextToken()); 
        	}
        }
        max=0;
        dfs(0);
        System.out.println(max);
        br.close();
        bw.close();
    }
    static void dfs(int cnt) {
    	if(cnt==3) {
    		bfs();
    		return;
    	}
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(arr[i][j]==0) {
    				arr[i][j]=1;
    				dfs(cnt+1);
    				arr[i][j]=0;
    			}
    		}
    	}
    }
    static void bfs() {
    	Queue<int[]> queue = new LinkedList<>();
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(arr[i][j]==2) {
    				queue.offer(new int[] {i,j});
    			}
    		}
    	}
    	int[][] tmp = new int[n][m];
    	for(int i=0; i<n; i++) {
    		tmp[i]= arr[i].clone(); 
    	}
    	while(!queue.isEmpty()) {
    		int[] now = queue.poll();
    		int nowX = now[0];
    		int nowY = now[1];
    		for(int i=0; i<4; i++) {
    			int nextX = nowX+dx[i];
    			int nextY = nowY+dy[i];
    			if(nextX<0 || nextY<0 || nextX>=n || nextY>=m) {
    				continue;
    			}
    			if(tmp[nextX][nextY]==0) {
    				tmp[nextX][nextY]=2;
    				queue.offer(new int[] {nextX,nextY});
    			}
    		}
    	}
    	int cnt=0;
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(tmp[i][j]==0)cnt++;
    		}
    	}
    	max = Math.max(max,cnt);
    }
}	
