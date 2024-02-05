package inflearn_8_dfs_bfs_uses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class inflearn8_7 {
	static int n,m,k;
	static int[][] arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static int cnt;
    static Set<Integer> set;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static long max;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[7][7];
        for(int i=0; i<7; i++) { 
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<7; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        visited = new boolean[7][7];
        cnt=0;
        visited[0][0]=true;
        dfs(0,0);
        System.out.println(cnt);
        br.close();
        bw.close();
    }
    static void dfs(int startX, int startY) {
    	if(startX==6 && startY==6) {
    		cnt++;
    		return;
    	}
    	for(int i=0; i<4; i++) {
    		int nextX = startX+dx[i];
    		int nextY = startY+dy[i];
    		if(nextX>=0 && nextY>=0 && nextX<7 && nextY<7 && arr[nextX][nextY]==0 && !visited[nextX][nextY]) {
    			visited[nextX][nextY]=true;
    			dfs(nextX,nextY);
    			visited[nextX][nextY]=false;
    		}
    	}
    }
}
