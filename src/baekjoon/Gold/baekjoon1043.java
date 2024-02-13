package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon1043 {
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
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i; 
		}
		party = new ArrayList[m];
		for(int i=0; i<m; i++) {
			party[i] = new ArrayList<>(); 
		}
		st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		trueMan = new ArrayList<>();
		if(num==0) {
			System.out.println(m);
			return;
		}
		for(int i=0; i<num; i++) {
			trueMan.add(Integer.parseInt(st.nextToken()));
		}
		for(int i=0; i<m; i++) {
			st =new StringTokenizer(br.readLine(), " ");
			int loop = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			party[i].add(first);
			for(int j=1; j<loop; j++) {
				int second = Integer.parseInt(st.nextToken());
				union(first, second);
				party[i].add(second);
			}
		
		}
		int cnt=0;
		for(int i=0; i<m; i++) {
			boolean check = false;
			for(int now : party[i]) {
				if(trueMan.contains(find(now))) {
					check = true;
					break;
				}
			}
			if(!check) {
				cnt++;
			}
		}
		System.out.println(cnt);
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
		if(trueMan.contains(y)) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		parent[y]= x; 
	}
}
