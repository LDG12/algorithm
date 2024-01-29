package inflearn_8_dfs_bfs_uses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class inflearn8_8 {
	static int n,m,k;
	static int[][] arr;
	static int[][] result;
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
        result = new int[7][7];
        visited[0][0]=true;
        bfs();
        System.out.println(result[6][6]==0?-1:result[6][6]);
        br.close();
        bw.close();
    }
    static void bfs() {
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[] {0,0});
    	visited[0][0]=true;
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int nowX= now[0];
    		int nowY =now[1];
    		for(int i=0; i<4; i++) {
    			int nextX = nowX+dx[i];
    			int nextY = nowY+dy[i];
    			if(nextX>=0 && nextY>=0 && nextX<7 && nextY<7 && arr[nextX][nextY]==0) {
    				arr[nowX][nowY]=1;
    				q.offer(new int[] {nextX,nextY});
    				result[nextX][nextY]=result[nowX][nowY]+1;
    			}
    		}
    	}
    }
}
