package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1074 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[][] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	static int[] parent;
	static int[] evenParent;
	static ArrayList<Integer>trueMan; 
	static ArrayList<Integer>[] party;
	static int whiteMax;
	static int blueMax;
	static int cnt;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt=0;
		int size = (int)Math.pow(2, n);
		divide(0, 0, size);
	}
	static void divide(int r, int c, int size) {
		if(size==1) {
			System.out.println(cnt);
			return;
		}
		int half = size/2;
		if(m<r+half && k<c+half) {
			divide(r, c, half);
		}else if(m<r+half && k>=c+half) {
			cnt+=((size*size)/4);
			divide(r, c+half, half);
		}else if(m>=r+half && k<c+half) {
			cnt+=((size*size)/4)*2;
			divide(r+half, c, half);
		}else if(m>= r+half && k>=c+half) {
			cnt+=((size*size)/4)*3;
			divide(r+half, c+half, half);
		}
	}
}
