package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon3190 {
	static class Point{
		int x,y;
		Point head;
		Point tail;
		public Point(int x ,int y) {
			this.x = x;
			this.y = y;
		}
		public Point(Point head, Point tail) {
			this.head = head;
			this.tail = tail;
		}
	}
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
	static Map<String, Double> lineage;
	static Map<String, ArrayList<String>> family;
	static StringBuilder sb;
	static int[] timer = new int[10001];
	static char[] orders = new char[10001];
	static List<Point>list; 

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x-1][y-1] = 2;
		}
		k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			char order = st.nextToken().charAt(0);
			timer[time] = 1;
			orders[time] = order; 
		}
		list = new LinkedList<>();
		int x =0;
		int y = 0;
		list.add(new Point(x, y));
		int direction = 0;
		int time=0;
		while(true) {
			time ++;
			int nextX = x+dx[direction];
			int nextY = y+dy[direction];
			if(isFinish(nextX, nextY))break;
			
			if(arr[nextX][nextY]== 0) {
				list.add(new Point(nextX, nextY));
				list.remove(0);
			}else if(arr[nextX][nextY]==2) {
				list.add(new Point(nextX, nextY));
				arr[nextX][nextY] = 0; 
			}
			if(timer[time]!=0) {
				char order = orders[time];
				if(order == 'D') {
					direction = (direction+1)%4;
				}
				else if(order=='L') {
					direction -=1;
					if(direction<0)direction = 3;
				}
			}
			x = nextX;
			y = nextY;
		}
		System.out.println(time);
	}
	static boolean isFinish(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=n)return true;
		for(int i=0; i<list.size();i ++) {
			Point now = list.get(i);
			if(now.x == x && now.y == y)return true;
		}
		return false;
	}
}
