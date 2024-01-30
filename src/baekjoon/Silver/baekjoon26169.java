package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon26169 {
	static int[] dx= {1,0,0,-1};
	static int[] dy= {0,1,-1,0};
	static int[][] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken()); 
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k=0;
		dfs(n, m, 0, 0);
		System.out.println(k);
	}
	static void dfs(int x,int y, int cnt, int sum) {
		if(arr[x][y]==1)sum++;
		if(cnt>=3) {
			if(sum>=2) {
				k=1;
			}
			return;
		}
		for(int i=0;i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(check(nextX, nextY)) {
				arr[x][y]=-1;
				dfs(nextX, nextY, cnt+1, sum);
				arr[x][y]=0;
			}
		}
	}
	static boolean check(int x, int y) {
		if(x<0 || y<0|| x>=5 || y>=5 || arr[x][y]==-1)return false;
		return true;
	}
}
