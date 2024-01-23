package inflearn._7_dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class inflearn7_5 {
	static int n,m,k;
	static int[] arr;
    static StringTokenizer st;
    static StringBuilder sb;
    static ArrayList<String> list;
    static boolean[] visited;
    static int min;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        visited = new boolean[10001];
        arr = new int[10001];
        bfs(n);
        System.out.println(min);
        br.close();
        bw.close();
    }
    static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(start);
    	visited[start]=true;
    	arr[start]=1;
    	int l=0;
    	int[] dx = {1,-1,5};
    	while(!q.isEmpty()) {
    		int len = q.size();
    		for(int i=0; i<len; i++) {
    			int now = q.poll();
    			if(now==m) {
    				min = l;
    				break;
    			}
    			for(int j=0; j<3; j++) {
    				int next = now+dx[j];
    				if(next>=1 && next<=10000 && arr[next]==0) {
    					q.offer(next);
    					arr[next]=1;
    				}
    			}
    		}
    		l++;
    	}
    }
}
