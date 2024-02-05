package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon1158 {
	/**
	 * @author 임동길
	 * @date 
	 * @link
	 * @keyword_solution  
	 * Stack의 pop 조건과 비교 조건
	 * 1. 현재의 내 value가 스택의 맨 위 value보다 작다면 StringBuilder에 저장 후 반복 탈출 (pop X)
	 * 2. 현재의 내 value가 스택의 맨 위 value와 같다면 flag를 변경 (pop O)
	 * -> pop을 하는 이유? 크기가 같다면 더 뒤의 인덱스를 먼저 마주볼 것이기 때문
	 * 3. 현재의 내 value가 스택의 맨 위 value보다 크다면? (pop O)
	 * -> 최소 같은것을 찾을때까지 반복. 못찾았다면 0을 StringBuilder에 저장
	 * @input 
	 * n이 최대 50만이기때문에 O(nⁿ)으로 풀면 시간초과
	 * O(n)으로 해결해야함
	 * @output
	 * 
	 * @time_complex 
	 * O(N)
	 * @perf 
	 * 141232KB, 796ms
	 */
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[] arr, oper;
	static int[] selectOper;
	static int direction;
	static int n,m,k, max, min;
	static Stack<Character>operStack;
	static Stack<Integer>intStack; 
	static StringTokenizer st;
	static boolean[] visited;
	static StringBuilder sb;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Queue<Integer>q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		sb = new StringBuilder();
		sb.append("<");
		while(q.size()>1) {
			for(int i=0; i<m-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()+", ");
		}
		String result = sb.toString();
		result+=q.poll()+">";
		System.out.println(result);
	}
}
