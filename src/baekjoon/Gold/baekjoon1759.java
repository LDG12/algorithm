package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class baekjoon1759 {
	static int[] dx= {1,0,0,-1};
	static int[] dy= {0,1,-1,0};
	static int[][] arr;
	static char[] arr2;
	static char[] result;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr2 = new char[m];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<m; i++) {
			arr2[i]=  st.nextToken().charAt(0);
		}
		Arrays.sort(arr2);
		result = new char[n];
		visited = new boolean[m];
		dfs(0, 0);
	}
	static void dfs(int depth, int start) {
		if(depth>=n) {
			int mo_cnt=0;
			int ja_cnt=0;
			String tmp="";
			for(char a : result) {
				if(a=='a'||a=='e'||a=='o'||a=='i'||a=='u') {
					mo_cnt++;
				}
				else {
					ja_cnt++;
				}
				tmp+=a;
			}
			if(mo_cnt>=1 && ja_cnt>=2) {
				System.out.println(tmp);
			}
			return;
		}
		for(int i=start; i<m; i++) {
			if(visited[i]==false) {
				visited[i]=true;
				result[depth]=arr2[i];
				dfs(depth+1, i);
				visited[i]=false;
			}
		}
	}
}
