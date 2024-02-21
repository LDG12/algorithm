package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon4803 {
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
	static boolean[][] visited;
	static int[] inDgree;
	static StringBuilder sb;
	static int[] parent;
	static Map<String, Integer> map;

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int tc = 1;; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			parent = new int[n + 1];
			Arrays.fill(parent, -1);
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				union(first, second);
			}
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (parent[i] < 0)
					cnt++;
			}
			sb.append("Case " + tc + ": ");
			if (cnt == 0) {
				sb.append("No trees.\n");
			} else if (cnt == 1) {
				sb.append("There is one tree.\n");
			} else {
				sb.append("A forest of " + cnt + " trees.\n");
			}
		}
		System.out.print(sb.toString());
	}

	static int find(int x) {
		if (parent[x] < 0) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			parent[x] = y;
			return;
		}
		if (x > y) {
			parent[y] += parent[x];
			parent[x] = y;
		} else {
			parent[x] += parent[y];
			parent[y] = x;
		}
	}
}
