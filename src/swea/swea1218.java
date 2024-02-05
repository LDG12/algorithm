package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class swea1218 {
	/**
	 * @author 임동길
	 * @date 2024-02-02
	 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV14eWb6AAkCFAYD&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=8&probBoxId=AY0LFFoqrIMDFAXz
	 * @keyword_solution  
	 * Stack의 push 및 pop 조건
	 * Stack이 empty일 때의 처리 방법
	 * 괄호 간 비교 조건
	 * @input 
	 * 10개의 테스트 케이스로 고정
	 * @output   
	 * 유효한 괄호라면 1, 유효하지않은 괄호라면 0
	 * @time_complex  
	 * O(N)
	 * @perf
	 * 18,648KB / 102ms 
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
			String word = br.readLine();
			Stack<Character>stack = new Stack<>();
			int flag = 1;
			for(int i=0; i<word.length(); i++) {
				char now = word.charAt(i);
				if(now=='[' || now=='{' || now=='(' || now=='<') {
					stack.push(now);
				}
				else {
					if(stack.isEmpty()) {
						flag=0;
						break;
					}
					char stackChar = stack.pop();
					boolean check = check(stackChar, now);
					if(!check) {
						flag=0;
						break;
					}
				}
			}
			sb.append("#"+(q+1)+" ");
			sb.append(flag+"\n");
		}
		System.out.println(sb.toString());
	}
	static boolean check(char stackChar, char now) {
		boolean check = false;
		if(now=='}') {
			if(stackChar=='{') {
				check = true;
			}
		}else if(now==']') {
			if(stackChar=='[')check = true;
		}else if(now==')') {
			if(stackChar=='(')check =true;
		}else if(now=='>') {
			if(stackChar=='<')check = true;
		}
		return check;
	}
}
