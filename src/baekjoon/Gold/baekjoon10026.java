package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon10026 {
	static int n, m, k;
	static StringTokenizer st;
	static StringBuilder sb;
	static int dist[], parent[];
	static char[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static boolean[][] rgVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		visited = new boolean[n][n];
		rgVisited = new boolean[n][n];
		int rgCnt = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(arr[i][j], i, j);
					cnt++;
				}
				if(!rgVisited[i][j]) {
					dfsForRG(arr[i][j], i, j);
					rgCnt++;
				}
			}
		}
		System.out.println(cnt+" "+rgCnt);
		br.close();
		bw.close();
	}

	static void dfs(char color, int x, int y) {
		visited[x][y] = true; 
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(!rangeCheck(nextX, nextY))continue;
			if(visited[nextX][nextY]== false && arr[nextX][nextY] == color) {
				dfs(color, nextX, nextY);
			}
		}
	}
	static void dfsForRG(char color, int x, int y){
		rgVisited[x][y] = true; 
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(!rangeCheck(nextX, nextY))continue;
			if(color == 'B') {
				if(!rgVisited[nextX][nextY] && arr[nextX][nextY] == color ) {
					dfsForRG(color, nextX, nextY);
				}
			}else {
				if(!rgVisited[nextX][nextY] && (arr[nextX][nextY] == 'R' || arr[nextX][nextY] == 'G') ) {
					dfsForRG(color, nextX, nextY);
				}
			}
		}
	}
	static boolean rangeCheck(int x,int y) {
		if(x>=0 && y>=0 && x<n && y<n)return true;
		return false;
	}
}
