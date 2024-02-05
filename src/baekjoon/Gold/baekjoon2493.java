package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon2493 {
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
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		Stack<int[]>stack = new Stack<>();
		sb = new StringBuilder();
		int cnt=1;
		while(st.hasMoreTokens()) {
			int now = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) {
				stack.push(new int[] {cnt, now});
				cnt++;
				sb.append("0 ");
				continue;
			}
			int stackValue=0;
			int stackCnt=0;
			int flag=0;
			while(!stack.isEmpty()) {
				int[] stacks = stack.peek();
				if(now>stacks[1]) {
					stack.pop();
				}
				else if(now == stacks[1]) {
					int[] tmp = stack.pop();
					stackValue = tmp[1];
					stackCnt = tmp[0];
					flag=1;
					break;
				}
				else { // now < stack[1]
					flag=1;
					int[] tmp = stack.peek();
					stackValue = tmp[1];
					stackCnt = tmp[0];
					break;
				}
			}
			if(flag==1) {
				sb.append(stackCnt+" ");
			}
			else {
				sb.append("0 ");
			}
			stack.push(new int[] {cnt,now});
			cnt++;
		}
		System.out.println(sb.toString());
	}
}
