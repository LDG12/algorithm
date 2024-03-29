package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author 임동길
 * @date 2024-02-21
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWBJKA6qr2oDFAWr&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0219%EC%A3%BC&problemBoxCnt=1&probBoxId=AY3JcG16dgMDFAXh
 * @keyword_solution  
 * Union Find
 * find에 나오는 결과값만을 이어붙이기
 * @input 
 * 1<=N<=1,000,000 // 1<=M<=1,000,000
 * @output   
 * 띄어쓰기없이 이어붙이기. ( 속해있다면 1, 속해있지 않다면 0 )
 * @time_complex  
 * O(NlogN)
 * @perf
 * 102,856kb / 507ms 
 */
public class swea3289 {
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static int[] arr2;
	static int direction;
	static int n, m, k;
	static StringTokenizer st;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static int min;
	static boolean[] visited;
	static int[] inDgree;
	static StringBuilder sb;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc =0 ; tc<T; tc++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			for(int i=1; i<=n; i++) {
				parent[i] = -1; 
			}
			sb.append("#"+(tc+1)+" ");
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int order = Integer.parseInt(st.nextToken());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				int result=0;
				if(order == 0) {
					result = union(first, second);
				}
				else if(order == 1) {
					int a = find(first);
					int b = find(second);
					if(a==b) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
	static int find(int x) {
		if(parent[x] < 0 ) {
			return x;
		}
		else {
			return parent[x] = find(parent[x]); 
		}
	}
	static int union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) {
			return 1;
		}
		else {
			if(parent[x] > parent[y]) {
				parent[x]+=parent[y];
				parent[y] = x;
			}
			else {
				parent[y] += parent[x];
				parent[x] = y; 
			}
			return 0;
		}
	}
}
