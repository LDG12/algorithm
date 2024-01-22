package baekjoon.Silver;

import static java.lang.Math.rint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1926 {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static boolean[][] visited;
    static ArrayList<Integer>list; 
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++) {
        	st= new StringTokenizer(br.readLine()," ");
        	for(int j=0; j<m; j++) {
        		arr[i][j]= Integer.parseInt(st.nextToken()); 
        	}
        }
        visited = new boolean[n][m];
        int cnt=0;
        list = new ArrayList<>();
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(arr[i][j]==1 && !visited[i][j]) {
        			cnt++;
        			bfs(i, j);
        		}
        	}
        }
        sb = new StringBuilder();
        sb.append(cnt);
        int max=0;
        for(int i : list) {
        	max = Math.max(i, max);
        }
        sb.append("\n"+max);
        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
    static void bfs(int startX, int startY) {
    	Queue<int[]> q= new LinkedList<>();
    	q.offer(new int[] {startX, startY});
    	visited[startX][startY]=true;
    	int cnt=1;
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int nowX = now[0];
    		int nowY = now[1];
    		for(int i=0; i<4; i++) {
    			int nextX = nowX+dx[i];
    			int nextY  = nowY+dy[i];
    			if(nextX<0 || nextY<0 ||nextX>=n ||nextY>=m) {
    				continue;
    			}
    			if(arr[nextX][nextY]==1 && !visited[nextX][nextY]) {
    				visited[nextX][nextY]=true;
    				cnt++;
    				q.offer(new int[] {nextX,nextY});
    			}
    		}
    	}
    	System.out.println("cnt = " +cnt);
    	list.add(cnt);
    }
}
