package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon5021 {
	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, 1, -1, 0 };
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
	static Map<String, Double> lineage;
	static Map<String, ArrayList<String>> family;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		family = new HashMap<>();
		lineage = new HashMap<>();
		String king = br.readLine();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String son = st.nextToken();

            if (family.get(son) == null) {
                family.put(son, new ArrayList<>());
            }

            String father = st.nextToken();
            family.get(son).add(father);
            String mother = st.nextToken();
            family.get(son).add(mother);

            lineage.put(son, -1d);
            lineage.put(father, -1d);
            lineage.put(mother, -1d);
        }

        lineage.put(king, 1d);

		lineage.put(king, 1d);
		circuit();
		String first = br.readLine();
		for(int i=1; i<m; i++) {
			String next = br.readLine();
			if(lineage.getOrDefault(first, 0d) < lineage.getOrDefault(next, 0d)) {
				first = next;
			}
		}
		System.out.println(first);
	}

	static void circuit() {
		for (String name : lineage.keySet()) {
			dfs(name);
		}
	}

	static double dfs(String name) {
		 if (lineage.get(name) != -1) {
	            return lineage.get(name);
	        }

		 if (family.get(name) == null) {
	            lineage.put(name, 0d);
	            return lineage.get(name);
	     }

	     double fatherBlood = dfs(family.get(name).get(0));
	     double motherBlood = dfs(family.get(name).get(1));

	 
	     lineage.put(name, (fatherBlood + motherBlood) / 2);

	     return lineage.get(name);
	}
}
