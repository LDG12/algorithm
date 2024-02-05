package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.LinkedList;
public class swea1225 {
	/**
	 * @author 임동길
	 * @date 2024-02-02
	 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV14uWl6AF0CFAYD&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=8&probBoxId=AY0LFFoqrIMDFAXz
	 * @keyword_solution  
	 * Queue에서 지속적인 poll과 offer가 이루어짐
	 * cnt가 5초과가 된다면 한 사이클이 끝난 것으로, 사이클 초기화
	 * @input 
	 * 10개의 테스트 케이스로 고정
	 * @output   
	 * 사이클이 종료된 이후의 queue의 원소들 출력
	 * @time_complex  
	 * O(N²)
	 * @perf
	 * 21,464KB / 122ms 
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
		sb = new StringBuilder();
		for(int q=0; q<10; q++) {
			n = Integer.parseInt(br.readLine());
			Queue<Integer>queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int cnt=1;
			while(!queue.isEmpty()) {
				int now = queue.poll()-cnt++;
				if(cnt==6)cnt=1;
				if(now<=0) {
					now = 0;
					queue.offer(now);
					break;
				}
				queue.offer(now);
			}
			sb.append("#"+(q+1)+" ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
