package inflearn._8_dfs_bfs_uses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class inflearn8_12 {
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int[] arr, oper;
	static int[] selectOper;
	static int direction;
	static int n,m,k, max, min;
	static Stack<Character>operStack;
	static Stack<Integer>intStack; 
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[m][n];
		Queue<int[]> q = new LinkedList<>();
		int ekCnt=0;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					q.offer(new int[] {i,j});
				}
				else if(arr[i][j]==0) {
					ekCnt++;
				}
			}
		}
		if(ekCnt==0) {
			System.out.println(0);
			return;
		}
		int trueCnt=0;
		while(!q.isEmpty()) {
			int size = q.size();
			int cnt=0;
			trueCnt++;
			for(int i=0; i<size; i++) {
				int[] now = q.poll();
				int nowX = now[0];
				int nowY = now[1];
				for(int j=0; j<4; j++) {
					int nextX = nowX+dx[j];
					int nextY = nowY+dy[j];
					if(check(nextX,nextY) && arr[nextX][nextY]==0) {
						arr[nextX][nextY]=1;
						cnt++;
						q.offer(new int[] {nextX,nextY});
					}
				}
			}
			ekCnt-=cnt;
			if(ekCnt==0) {
				break;
			}
		}
		System.out.println(ekCnt==0?trueCnt:-1);
	}
	static boolean check(int x, int y) {
		if(x<0 || y<0 || x>=m||y>=n)return false;
		return true;
	}
}
