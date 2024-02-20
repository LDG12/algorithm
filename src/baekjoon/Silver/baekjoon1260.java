package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1260 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[][] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	static int max;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to]= arr[to][from] = 1; 
		}
		visited = new boolean[n+1];
		dfs(k);
		visited = new boolean[n+1];
		System.out.println();
		bfs(k);
	}
	static void dfs(int start) {
		System.out.print(start+" ");
		visited[start] = true; 
		for(int i=1; i<=n; i++) {
			if(!visited[i] && arr[start][i] ==1 ) {
				dfs(i);
			}
		}
	}
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now+" ");
			for(int i=1; i<=n; i++) {
				if(visited[i] == false && arr[now][i] ==1) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
