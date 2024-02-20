package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2636 {
	static class Cheese {
		int x, y;

		public Cheese(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, 1, -1, 0 };
	static int[][] arr;
	static int[] arr2;
	static int direction;
	static int n, m, k;
	static StringTokenizer st;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static int min;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		int cheeseCnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					cheeseCnt++;
			}
		}
		int time = 0;
		int prev = 0;

		while (cheeseCnt > 0) {
			time++;
			prev = cheeseCnt;
			cheeseCnt -= bfs();
		}
		System.out.println(time);
		System.out.println(prev);
	}

	static int[][] copyArray() {
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
	static int bfs() {
		Queue<Cheese> q = new ArrayDeque<>();
		q.offer(new Cheese(0, 0));
		int[][] copy = copyArray();
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Cheese now  = q.poll();
				for(int j=0; j<4; j++) {
					int nextX = now.x+dx[j];
					int nextY = now.y+dy[j];
					if(!rangeCheck(nextX, nextY))continue;
					if(visited[nextX][nextY])continue;
					if(copy[nextX][nextY] == 2 )continue;
					visited[nextX][nextY] = true; 
					if(copy[nextX][nextY] == 1 ) {
						copy[nextX][nextY] = 2; 
					}
					else if(copy[nextX][nextY] == 0 ) {
						q.offer(new Cheese(nextX, nextY));
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 2) {
					arr[i][j] = 0;
					cnt++;
				}
			}
		}
		return cnt;
	}

	static boolean rangeCheck(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m)
			return true;
		return false;
	}
}
