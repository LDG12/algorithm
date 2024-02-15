package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class swea1873 {
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};  // 0 = 남 // 1 = 동 // 2 = 북 // 3 = 서
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	static char[][] arr2;
	static int max;
	static char[] oper;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr2 = new char[n][m];
			int startX = 0;
			int startY = 0;
			int direction = 0;
			
			for(int i = 0; i < n; i++) {
				String tmp = br.readLine();
				for(int j = 0; j < m; j++) {
					char now = tmp.charAt(j);
					arr2[i][j] = now;
					
					if(now == '<' || now == '>' || now == '^' || now == 'v') {
						startX = i;
						startY = j;
						direction = jeonchaToDirection(now);
					}
				}
			}
			
			k = Integer.parseInt(br.readLine());
			oper = br.readLine().toCharArray();
			sb.append("#"+(tc+1)+" ");
			dfs(startX, startY, 0, direction);
		}
		System.out.println(sb.toString());
	}
	// 0 = 남 // 1 = 동 // 2 = 북 // 3 = 서
	static void dfs(int x, int y, int depth, int direction) {
		if(depth>=k) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					sb.append(arr2[i][j]);
				}
				sb.append("\n");
			}
			return;
		}
		
		char nowOper = oper[depth];
		int now = operToDirection(nowOper);
		if(now==-1) {
			int nowDirection = direction;
			shoot(x, y, nowDirection);
			dfs(x, y, depth+1, nowDirection);
		}
		else {
			int nextX = x + dx[now];
			int nextY = y + dy[now];
			
			if(moveCheck(nextX, nextY)) {
				arr2[nextX][nextY] = directionToJeoncha(now);
				arr2[x][y] ='.';
				dfs(nextX, nextY, depth+1, now);
			}else {
				arr2[x][y] = directionToJeoncha(now);
				dfs(x, y, depth+1, now);
			}
		}
	}
	
	static void shoot(int x, int y, int direction) {
		int nextX = x + dx[direction];
		int nextY = y + dy[direction];
		boolean flag = false;
		
		while(shootCheck(nextX, nextY)) {
			if(arr2[nextX][nextY] == '*' ) {
				flag = true;
				break;
			}
			nextX += dx[direction];
			nextY += dy[direction];
		}
		
		if(flag) {
			arr2[nextX][nextY] = '.'; 
		}
		
	}
	
	static boolean shootCheck(int x, int y) {
		if(x >= 0 && y >= 0 && x < n && y < m && arr2[x][y]!='#' ) {
			return true;
		}
		return false;
	}
	
	static boolean moveCheck(int x, int y) {
		if(x >= 0 && y >= 0 && x < n && y < m) {
			if(arr2[x][y] == '.') {
				return true;
			}
			return false;
		}
		return false;
	}
	
	static int operToDirection(char oper) { // 남 동 북 서 0 1 2 3
		int now = 0;
		if(oper == 'U') {
			now = 2;
		}
		else if(oper == 'D') {
			now = 0;
		}
		else if(oper == 'L') {
			now = 3;
		}
		else if(oper == 'R') {
			now = 1;
		}
		else if(oper == 'S') {
			now = -1;
		}
		return now;
	}
	
	static char directionToJeoncha(int direction) {
		char now = '\0';
		if(direction == 0) {
			now = 'v';
		}
		else if(direction == 1) {
			now = '>';
		}
		else if(direction == 2) {
			now = '^';
		}
		else if(direction == 3) {
			now = '<';
		}
		return now;
	}
	
	static int jeonchaToDirection(char jeoncha) {
		int direction = 0;
		if(jeoncha == '<') {
			direction = 3;
		}
		else if(jeoncha == '>') {
			direction = 1;
		}
		else if(jeoncha == '^') {
			direction = 2;
		}
		else if(jeoncha == 'v') {
			direction = 0;
		}
		return direction;
	}
}
