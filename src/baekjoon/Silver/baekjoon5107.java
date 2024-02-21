package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon5107 {
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
		for(int tc=1;;tc++) {
			n = Integer.parseInt(br.readLine());
			if(n==0)break;
			map = new HashMap<String, Integer>();
			parent = new int[n];
			sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				parent[i] = -1;
			}
			int mapIndex = 0;
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
					String firstName = st.nextToken();
					String secondName = st.nextToken();
					int firstIndex = 0;
					int secondIndex = 0;
					if (map.containsKey(firstName)) {
						firstIndex = map.get(firstName);
					} else {
						firstIndex = mapIndex;
						map.put(firstName, mapIndex++);
					}
					if (map.containsKey(secondName)) {
						secondIndex = map.get(secondName);
					} else {
						secondIndex = mapIndex;
						map.put(secondName, mapIndex++);
					}
					union(firstIndex, secondIndex);
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (parent[i] < 0) {
					cnt++;
				}
			}
			sb.append(tc).append(" " + cnt);
			System.out.println(sb.toString());
		}
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
		if (x == y)
			return;
		if (x > y) {
			parent[x] += parent[y];
			parent[y] = x;
		} else {
			parent[y] += parent[x];
			parent[x] = y;
		}
	}
}
