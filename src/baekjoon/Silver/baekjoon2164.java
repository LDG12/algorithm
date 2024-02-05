package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon2164 {
	/**
	 * @author 임동길
	 * @date 2024-02-02
	 * @link  https://www.acmicpc.net/problem/2164
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
	 * 51140kb /	 148ms 
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
		n = Integer.parseInt(br.readLine());
		Queue<Integer>q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		while(q.size()>1) {
			q.poll();
			int now = q.poll();
			q.offer(now);
		}
		System.out.println(q.poll());
	}
}
