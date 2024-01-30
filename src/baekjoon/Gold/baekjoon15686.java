package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon15686 {
	static int[] dx= {1,0,0,-1};
	static int[] dy= {0,1,-1,0};
	static int[][] arr;
	static int[] arr2;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static ArrayList<int[]>chicken;
	static ArrayList<int[]>house;
	static int min;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					chicken.add(new int[] {i,j});
				}
				else if(arr[i][j]==1) {
					house.add(new int[] {i,j});
				}
			}
		}
		arr2 = new int[m];
		min = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(min);
	}
	static void dfs(int depth, int start) {
		if(depth>=m) {
			int result=0;
			for(int[] h : house) {
				int distance = Integer.MAX_VALUE;
				for(int i : arr2) {
					distance = Math.min(distance, Math.abs(h[0]-chicken.get(i)[0])+Math.abs(h[1]-chicken.get(i)[1]));
				}
				result+=distance;
			}
			min = Math.min(min,result);
			return;
		}
		for(int i=start; i<chicken.size(); i++) {
			arr2[depth]= i;
			dfs(depth+1, i+1);
		}
	}
}
