package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1976 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	static int[] parent;
	static ArrayList<Integer>trueMan; 
	static ArrayList<Integer>[] party;
	static int max;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i]= i; 
		}
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now==1) {
					union(i, j);
				}
			}
		}
		boolean check = false;
		st = new StringTokenizer(br.readLine(), " ");
		int now = find(Integer.parseInt(st.nextToken()));
		for(int i=1; i<m; i++) {
			if(now!=find(Integer.parseInt(st.nextToken()))) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	static int find(int x) {
		if(x==parent[x]) {
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
				parent[y] = x; 
			}
		}
	}
}
