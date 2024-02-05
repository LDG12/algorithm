package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class swea1210 {
	/**
	 * @author 임동길
	 * @date  2024-01-30
	 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV14ABYKADACFAYh&probBoxId=AY0LFFoqrIMDFAXz+&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=++4+
	 * @keyword_solution  
	 * 3방탐색(좌, 우, 하)
	 * 재귀의 종료 조건( '2'를 만났을 때)
	 * 하향 진행과 좌,우 진행중일때의 대처
	 * @input 
	 * 100*100 사이즈의 2차원 배열로 고정
	 * @output   
	 * 좌표의 끝에서 '2'를 만날 수 있는 시작지점을 출력
	 * @time_complex  
	 *
	 * @perf
	 * 34,016kb 메모리 / 161ms 시간. 
	 */
	static int[] dx= {1,0,0};
	static int[] dy= {0,1,-1};
	static int[][] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int q=0; q<10; q++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<100; j++) {
					arr[i][j]= Integer.parseInt(st.nextToken()); 
//					if(arr[i][j]==2)System.out.println("i == "+i + " // j = "+j);
				}
			}
			for(int i=0; i<100; i++) {
				if(arr[0][i]==1) {
					dfs(0,i,0,i);
				}
			}
		}
	}
	static void dfs(int x, int y, int direction, int startX) {
//		System.out.println("x = "+x +" // y = "+ y+ " // direction = " +direction);
		if(arr[x][y]==2) {
			System.out.println("#"+(n)+" "+startX);
			return;
		}
		int nextX=0;
		int nextY=0;
		int nextDirection=0;
		boolean sideFlag = false;
		if(direction==0) {
			for(int i=1; i<3; i++) {
				nextX = x+dx[i];
				nextY = y+dy[i];
				if(check(nextX, nextY)) {
					nextDirection=i;
					sideFlag=true;
					break;
				}
			}
			if(sideFlag) {
				dfs(nextX, nextY, nextDirection, startX);
			}else {
				nextX = x+1;
				nextY = y;
				if(check(nextX, nextY)) {
					dfs(nextX, nextY, 0, startX);
				}
			}
		}
		else {
			nextX = x+1;
			nextY = y;
			if(check(nextX, nextY)) {
				dfs(nextX, nextY, 0, startX);
			}
			else {
				nextX = x+dx[direction];
				nextY = y+dy[direction];
				if(check(nextX, nextY)){
					dfs(nextX, nextY, direction, startX);
				}
			}
		}
		
	}
	static boolean check(int x, int y) {
		if(x>=0 && y>=0 && x<100 && y<100 && (arr[x][y]==1 || arr[x][y]==2)) {
			return true;
		}
		return false;
	}
}
