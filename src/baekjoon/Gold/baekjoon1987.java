package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon1987 {
	static int n,m,k;
    static StringTokenizer st;
    static char[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static boolean[] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine()," ");
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    arr = new char[n][m];
	    for(int i=0; i<n; i++) {
	    	String tmpString = br.readLine();
	    	for(int j=0; j<m; j++) {
	    		arr[i][j] = tmpString.charAt(j);
	    	}
	    }
        max = Integer.MIN_VALUE;
        visited = new boolean[26];
        dfs(0, 0, 1);
        System.out.println(max);
        br.close();
        bw.close();
    }
    static void dfs(int startX, int startY, int cnt) {
    	visited[arr[startX][startY]-'A']=true;
    	for(int i=0; i<4; i++) {
    		int nextX = startX+dx[i];
    		int nextY = startY+dy[i];
    		if(nextX<0||nextY<0||nextX>=n||nextY>=m)continue;
    		if(visited[arr[nextX][nextY]-'A']==false) {
    			dfs(nextX, nextY, cnt+1);
    			visited[arr[nextX][nextY]-'A']=false;
    		}
    		
    	}
    	max = Math.max(max, cnt);
    }
}
