package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1861 {
	/**
	 * @author 임동길
	 * @date  2024-02-06
	 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&categoryId=AW8Wj7cqbY0DFAXN&categoryType=CODE&problemTitle=9229&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * @keyword_solution 
	 * 1. 백트래킹
	 * 2. O(2ⁿ)으로 제약 없는 재귀를 진행하면, 최악의 케이스에서 엄청난 시간이 소모
	 * 3. 재귀가 들어가기 전 과자들의 무게를 정렬하여 진행
	 * @input 
	 * 2<=N<=1000
	 * 2<=M<=2,000,000
	 * @output   
	 * 2가지를 선택했을 때 가장 큰 MAX 값 출력 (int 범위 내)
	 * @time_complex  
	 * O(n²)
	 * @perf 
	 * 27,892kb / 152ms
	 */
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr;
	static Integer[] snack;
	static int direction;
	static int n,m,k, max, min;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					arr[i][j] =Integer.parseInt(st.nextToken()); 
				}
			}
			max = 1;
			int maxBang=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int sum = bfs(i, j, arr[i][j]);
					if(max<sum) {
						max = sum;
						maxBang = arr[i][j];
					}
					else if(max==sum && maxBang>arr[i][j]) {
						maxBang = arr[i][j];
					}
				}
			}
			System.out.println("#"+(tc+1)+" "+maxBang+" "+max);
		}
	}
	static int bfs(int x,int y, int value) {
		Queue<Node> q = new java.util.LinkedList<>();
		q.offer(new Node(x,y,value));
		int cnt=0;
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for(int i=0; i<size; i++) {
				Node now = q.poll();
				for(int j=0; j<4; j++) {
					int nextX = now.x + dx[j];
					int nextY = now.y + dy[j];
					if(check(nextX, nextY)&& arr[nextX][nextY]==now.cnt+1) {
						q.offer(new Node(nextX,nextY,arr[nextX][nextY]));
					}
				}
			}
		}
		return cnt;
	}
	static boolean check(int x,int y) {
		if(x<0|| y<0|| x>=n || y>=n)return false;
		return true;
	}
}
class Node{
	int x;
	int y;
	int cnt;
	
	public Node() {}
	public Node(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
	}
	
}
