package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1247 {
	/**
	 * @author 임동길
	 * @date 2024-02-15
	 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV15OZ4qAPICFAYD&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0212%EC%A3%BC&problemBoxCnt=5&probBoxId=AY2gBgM6OSIDFAXh
	 * @keyword_solution  
	 * 1. 고객의 최대 수는 10
	 * 2. 순서가 상관이 있기 때문에 순열을 사용한다면 10P10 -> 10! / 1!
	 * --> 최대 10!이기 때문에 360만가지 경우
	 * 3. 가지치기를 안하는 순수 순열의 경우 1800ms, 백트래킹 실시 결과 300ms
	 * @input 
	 * 회사와 집의 위치, 각 고객의 위치가 나타난다.
	 * @output   
	 * 최소값 출력
	 * @time_complex  
	 * O(N!)
	 * @perf 
	 * 20,056KB, 312ms
	 */
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
	static int[] company;
	static int[] home;
	static int[][] customers;
	static int[][] saveDistance;
	static int min;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			company = new int[2];
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			
			home = new int[2];
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			saveDistance = new int[n][2];
			customers = new int[n][2];
			for(int i=0; i<n; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[n];
			
			
			min = Integer.MAX_VALUE;
			dfs(0, company[0], company[1], 0);
			sb.append("#"+(tc+1)+" "+min+"\n");
		}	
		System.out.print(sb.toString());
	}
	
	static void dfs(int depth, int x, int y, int sum) {
		if(sum>=min)return;
		if(depth>=n) {
			sum += Math.abs(x - home[0]) + Math.abs(y - home[1]);
			min = Math.min(min, sum);
			return;
		}
		
		
		for(int i = 0; i < n; i++) {
			if(visited[i] == false ) {
				visited[i] = true;
				int tmp = Math.abs(x - customers[i][0]) + Math.abs(y - customers[i][1]);
				dfs(depth+1, customers[i][0], customers[i][1], sum+tmp);
				visited[i] = false; 
			}
		}
	}
}
