package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea1954 {
	/**
	 * @author 임동길
	 * @date 2024-01-31
	 * @link 
	 * https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV5PobmqAPoDFAUq&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=5&probBoxId=AY0LFFoqrIMDFAXz
	 * @keyword_solution  
	 * 4방탐색.
	 * 제한조건을 만나기 전까지는 계속 한 방향으로 쭉 전진
	 * 제한조건은 배열의 범위초과 or 이미 방문한 배열좌표
	 * @input 
	 * TestCase의 입력과 2차원 배열 x,y의 크기인 n이 입력으로 주어진다
	 * @output   
	 * 2차원 배열에 들어가는 값으 크기는 n*n의 값을 넘을 수 없다
	 * @time_complex  
	 * O(N²)
	 * @perf
	 * 18,472kb / 109ms 
	 */
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[][]arr, oper;
	static int direction;
	static int n,m,k, max, min;
	static Stack<Character>stack; 
	static StringTokenizer st;
	static StringBuilder sb;
	static boolean[] visited;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int q=0; q<tc; q++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			int cnt=1;
			int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			int direction=0;
			int x=0;
			int y=0;
			while(cnt<=(n*n)) {
				arr[x][y]=cnt++;
				int nextX=x+dx[direction];
				int nextY=y+dy[direction];
				if(nextX<0||nextY<0||nextX>=n||nextY>=n || arr[nextX][nextY]!=0) {
					direction = (direction+1)%4;
					nextX = x+dx[direction];
					nextY = y+dy[direction];
				}
				x=nextX;
				y=nextY;
			}
			sb.append("#"+(q+1)+"\n");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
