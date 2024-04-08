package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon11659 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[]arr, oper;
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
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int depth = 0;
		while(Math.pow(2,depth)<n){
			depth++;
		}
		depth++;
		int treeSize = (int)Math.pow(2, depth);
		int startIndex = (int)Math.pow(2, depth-1);
		int[] segmentTree = new int[treeSize];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++){
			segmentTree[startIndex+i] = Integer.parseInt(st.nextToken());
		}
		for(int i = startIndex-1; i>=1; i--){
			segmentTree[i] = segmentTree[i*2] + segmentTree[i*2+1];
		}
		sb = new StringBuilder();
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine(),  " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int start = a+startIndex-1;
			int end = b+startIndex-1;
			int ans = 0;
			while(start<=end){
				if(start%2==1)ans+=segmentTree[start];
				if(end%2==0)ans+=segmentTree[end];
				start = (start+1)/2;
				end = (end-1)/2;
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb.toString());
	}
}
