package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea2805 {
	/**
	 * @author 임동길
	 * @date 2024-01-30
	 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV139KOaABgCFAYh&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=4
	 * @keyword_solution  
	 * 제한시간이 20초로 매우 넉넉함 (약 20억번의 연산)
	 * Arrays.sort의 시간복잡도 평균 O(nlog(n)) / 최악 O(n^2)
	 * 100 * 6  / 10000 / 덤프는 1000이하
	 * @input 
	 * 덤프의 횟수와 100개의 가로길이가 주어진다.
	 * @output   
	 * 덤프 횟수 종료 이후의 최소값과 최대값의 편차를 출력한다
	 * @time_complex  
	 * 평균 600000 / 최악 10000000
	 * @perf 
	 * 21,308kb 메모리 / 123ms 시간
	 */
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[] arr;
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
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[100];
			for(int i=0; i<100; i++) {
				arr[i]= Integer.parseInt(st.nextToken()); 
			}
			Arrays.sort(arr);
			int cnt=0;
			while(n>0) {
				arr[0]++;
				arr[99]--;
				cnt++;
				n--;
				if(arr[0]==arr[99])break;
				Arrays.sort(arr);
			}
			System.out.println(arr[99]-arr[0]);
		}
		
	}
}
