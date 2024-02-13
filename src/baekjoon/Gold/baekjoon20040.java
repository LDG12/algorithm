package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon20040 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	static int[] parent;
	static int[] evenParent;
	static ArrayList<Integer>trueMan; 
	static ArrayList<Integer>[] party;
	static int max;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent= new int[n];
		evenParent = new int[n];
		for(int i=0; i<n; i++) {
			parent[i] = i ;
			evenParent[i] = i; 
		}
		int result=0;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			System.out.println(Arrays.toString(parent));
			if(find(first)!=find(second)) {
				union(first, second);
			}else {
				result=(i+1);
				break;
			}
		}
		System.out.println(result);
	}
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return find(parent[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) {
			if(x>y) {
				parent[x]=y;
			}else {
				parent[y]=x;
			}
		}
	}
}
