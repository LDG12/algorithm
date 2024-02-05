package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea1248 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static char[] arr, oper;
	static int[] selectOper;
	static int direction;
	static int n,m,k, max, min, start, end;
	static Stack<Character>operStack;
	static Stack<Integer>intStack; 
	static StringTokenizer st;
	static boolean[] visited;
	static StringBuilder sb;
	static ArrayList<Integer>[] list;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int q=0; q<tc; q++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			int[] parents = new int[n+1];
			list = new ArrayList[n+1];
			for(int i=0; i<=n; i++) {
				list[i]= new ArrayList<>(); 
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parents[child]= parent; 
				list[parent].add(child);
			}
			int cnt=0;
			ArrayList<Integer> firstChild = new ArrayList<>();
			ArrayList<Integer> secondChild = new ArrayList<>(); 
			while(parents[start]!=0) {
				firstChild.add(parents[start]);
				start = parents[start];
			}
			while(parents[end]!=0) {
				secondChild.add(parents[end]);
				end = parents[end];
			}
			k = 0;
			firstChild.retainAll(secondChild);
			k = firstChild.get(0);
			cnt=0;
			visited = new boolean[n+1];
			int result = dfs(k);
			System.out.println("#"+(q+1)+" "+k+" "+result);
		}
	}
	static int dfs(int start) {
		int cnt=1;
		for(int i=1; i<=n; i++) {
			if(visited[i]==false && list[start].contains(i)) {
				visited[i]= true; 
				cnt+=dfs(i);
				visited[i]=false; 
			}
		}
		return cnt;
	}
}
