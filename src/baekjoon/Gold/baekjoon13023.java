package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon13023 {
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
	static char[] choosed;
	static char[] alpha;
	static int answer = 0;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (answer == 0) {
				dfs(0, i);
			}
		}
		System.out.println(answer);
	}

	static void dfs(int depth, int start) {
		if (depth >= 4) {
			answer = 1;
			return;
		}
		visited[start] = true;
		for (int i : list[start]) {
			if (!visited[i]) {
				dfs(depth + 1, i);
			}
		}
		visited[start] = false;
	}
}
