package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class baekjoon15683 {
	static class Camera{
		int x,y,num;
		public Camera(int x,int y,int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] dx2 = { {0,1,0,-1} ,{1,1}};
	static int[][] arr;
	static int n, m, k;
	static StringTokenizer st;
	static boolean[][] visited;
	static StringBuilder sb;
	static int[] parent;
	static Camera[] camera = new Camera[8];
	static int cameraCnt = 0;
	static int blind;
	static int min;
	
	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
				if(arr[i][j]>0 && arr[i][j] <6 ) {
					camera[cameraCnt++] = new Camera(i, j, arr[i][j]);
				}
			}
		}
		min = Integer.MAX_VALUE;
		int[][] copy = copyArray();
		dfs(0, copy);
		System.out.println(min);
	}
	
	
	static void dfs(int depth, int[][] map) {
		if(depth==cameraCnt) {
			int result = isMax(map);
			min = Math.min(min, result);
			return;
		}
		int now = camera[depth].num;
		int x = camera[depth].x;
		int y = camera[depth].y;
		int[][] permuArr;
		if(now == 1) {
			dfs(depth+1, checkRight(x, y, map));
			dfs(depth+1, checkLeft(x, y, map));
			dfs(depth+1, checkUp(x, y, map));
			dfs(depth+1, checkDown(x, y, map));
		}
		else if(now == 2) {
			permuArr = copyArray(map);
			permuArr = checkLeft(x, y, permuArr);
			permuArr = checkRight(x, y, permuArr);
			dfs(depth+1, permuArr);
			permuArr = copyArray(map);
			permuArr = checkUp(x, y, permuArr);
			permuArr = checkDown(x, y, permuArr);
			dfs(depth+1, permuArr);
		}
		else if(now == 3) {
			permuArr = copyArray(map);
			permuArr = checkUp(x, y, permuArr);
			permuArr = checkRight(x, y, permuArr);
			dfs(depth+1, permuArr);
			permuArr = copyArray(map);
			permuArr = checkRight(x, y, permuArr);
			permuArr = checkDown(x, y, permuArr);
			dfs(depth+1, permuArr);
			permuArr = copyArray(map);
			permuArr = checkDown(x, y, permuArr);
			permuArr = checkLeft(x, y, permuArr);
			dfs(depth+1, permuArr);
			permuArr = copyArray(map);
			permuArr = checkLeft(x, y, permuArr);
			permuArr = checkUp(x, y, permuArr);
			dfs(depth+1, permuArr);
		}
		else if(now == 4) {
			permuArr = copyArray(map);
			permuArr = checkLeft(x, y, permuArr);
			permuArr = checkUp(x, y, permuArr);
			permuArr = checkRight(x, y, permuArr);
			dfs(depth+1, permuArr);
			permuArr = copyArray(map);
			permuArr = checkDown(x, y, permuArr);
			permuArr = checkUp(x, y, permuArr);
			permuArr = checkRight(x, y, permuArr);
			dfs(depth+1, permuArr);
			permuArr=copyArray(map);
			permuArr = checkRight(x, y, permuArr);
			permuArr = checkDown(x, y, permuArr);
			permuArr = checkLeft(x, y, permuArr);
			dfs(depth+1, permuArr);
			permuArr = copyArray(map);
			permuArr = checkDown(x, y, permuArr);
			permuArr = checkLeft(x, y, permuArr);
			permuArr = checkUp(x, y, permuArr);
			dfs(depth+1, permuArr);
		}
		else if(now ==5) {
			permuArr = copyArray(map);
			permuArr = checkDown(x, y, permuArr);
			permuArr = checkLeft(x, y, permuArr);
			permuArr = checkRight(x, y, permuArr);
			permuArr = checkUp(x, y, permuArr);
			dfs(depth+1, permuArr);
		}
	}
	
	
	
	
	

	static int[][] copyArray() {
		int[][] copy = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m;j ++) {
				copy[i][j] = arr[i][j]; 
			}
		}
		return copy;
	}
	static int[][] copyArray(int[][] arr){
		int[][] copy = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0;j <m;j ++) {
				copy[i][j] = arr[i][j]; 
			}
		}
		return copy;
	}
	static int[][] checkRight(int x,int y, int[][] map) {
		int[][] copy = copyArray(map);
		for(int i=y+1; i<m; i++) {
			if(!rangeCheck(x, i))break;
			if(!isCCTV(x, i)) {
				copy[x][i] = -1;
			}
		}
		return copy;
	}
	static int[][] checkLeft(int x,int y, int[][] map) {
		int[][] copy = copyArray(map);
		for(int i=y-1; i>=0; i--) {
			if(!rangeCheck(x, i))break;
			if(!isCCTV(x, i)) {
				copy[x][i] = -1;
			}
		}
		return copy;
	}
	static int[][] checkUp(int x,int y, int[][] map) {
		int[][] copy = copyArray(map);
		for(int i=x-1; i>=0; i--) {
			if(!rangeCheck(i, y))break;
			if(!isCCTV(i, y)) {
				copy[i][y] = -1;
			}
		}
		return copy;
	}
	static int[][] checkDown(int x,int y, int[][] map) {
		int[][] copy = copyArray(map);
		for(int i=x+1; i<n; i++) {
			if(!rangeCheck(i, y))break;
			if(!isCCTV(i, y)) {
				copy[i][y] = -1;
			}
		}
		return copy;
	}
	static int isMax(int[][] arr2) {
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr2[i][j] == 0 ) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	static boolean isCCTV(int x, int y) {
		if(arr[x][y]>0 && arr[x][y]<6)return true;
		return false;
	}
	static boolean rangeCheck(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=m)return false;
		if(arr[x][y] == 6 )return false;
		return true;
	}
}
