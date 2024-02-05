package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea1231 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static char[] arr, oper;
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
		for(int q=0; q<10; q++) {
			n = Integer.parseInt(br.readLine());
			arr = new char[n+1];
			oper = new char[n+1];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int index =0;
				char word = '\0';
				int tmp1 = 0;
				int tmp2 = 0;
				if(st.countTokens()==4) {
					index = Integer.parseInt(st.nextToken());
					word = st.nextToken().charAt(0);
					tmp1= Integer.parseInt(st.nextToken());
					tmp2 = Integer.parseInt(st.nextToken());
				}else if(st.countTokens()==3) {
					index = Integer.parseInt(st.nextToken());
					word = st.nextToken().charAt(0);
					tmp1= Integer.parseInt(st.nextToken());
				}else {
					index = Integer.parseInt(st.nextToken());
					word = st.nextToken().charAt(0);
				}
				arr[index] = word; 
			}
			System.out.print("#"+(q+1)+" ");
			dfs(1);
			System.out.println();
		}
	}
	static void dfs(int depth) {
		if(depth>n) {
			return;
		}
		dfs(depth*2);
		System.out.print(arr[depth]);
		dfs(depth*2+1);
	}
}
