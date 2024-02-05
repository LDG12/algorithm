package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea2001 {
	/**
	 * @author 임동길
	 * @date 2024-02-01
	 * @link 
	 * https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV5PzOCKAigDFAUq&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=6
	 * @keyword_solution  
	 * 4중 for문 혹은 주어진 범위 내의 탐색
	 * 반복문의 종료조건 설정.
	 * 
	 * @input 
	 * 5<= N <= 15
	 * 2<= M <= N
	 * worst 케이스는 N⁴ => 약 5만 브루트포스 가능
	 * @output   
	 * 한 범위 내의 최대 파리수는 30
	 * int 범위 내에서 출력 가능
	 * @time_complex  
	 * O(N⁴)
	 * @perf
	 * 17,984kb / 111ms 
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
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max=0;
			for(int i=0; i<=n-m; i++) {
				for(int j=0; j<=n-m; j++) {
					int sum=0;
					for(int k=i; k<i+m; k++) {
						for(int l=j; l<j+m; l++) {
							sum+=arr[k][l];
						}
					}
					max = Math.max(sum,max);
				}
			}
			sb.append("#"+(q+1)+" "+max+"\n");
		}
		System.out.println(sb.toString());
	}
}
