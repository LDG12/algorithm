package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.java.swing.plaf.windows.resources.windows;

public class baekjoon6987 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[][] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static int[][] visited;
	static int result;
	static int max;
	static int[] t1, t2;
	static int[][] match;
	static char[] winOrlose;
	static int[] totalCnt;
	static int[] win,draw,lose;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[6][3];
		match = new int[6][3];
		sb = new StringBuilder();
		for(int i=0; i<4; i++) {
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			st = new StringTokenizer(br.readLine(), " ");
			int sum=0;
			for(int j = 0; j < 6; j ++) {
				for (int k = 0; k < 3; k ++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
				win[j] =  arr[j][0];
				draw[j] = arr[j][1];
				lose[j] = arr[j][2]; 
				sum+=win[j]+draw[j]+lose[j];
			}
			t1 = new int[15];
			t2 = new int[15];
			int cnt=0;
			for(int j=0; j<5; j++) {
				for(int k=j+1; k<6; k++) {
					t1[cnt] = j;
					t2[cnt++] = k;
				}
			}
			result = 0;
			if(sum==30) {
				backTracking(0);
			}
			sb.append(result+" ");
		}
		System.out.println(sb.toString().trim());
	}
	static void backTracking(int round) {
		if(result==1)return;
		if(round==15) {
			result=1;
			return;
		}
		int t1Index = t1[round];
		int t2Index = t2[round];
		if(win[t1Index]>0 && lose[t2Index]>0) {
			win[t1Index]--;
			lose[t2Index]--;
			backTracking(round+1);
			win[t1Index]++;
			lose[t2Index]++;
		}
		if(draw[t1Index]>0 && draw[t2Index]>0) {
			draw[t1Index]--;
			draw[t2Index]--;
			backTracking(round+1);
			draw[t1Index]++;
			draw[t2Index]++;
		}
		if(lose[t1Index]>0 && win[t2Index]>0) {
			lose[t1Index]--;
			win[t2Index]--;
			backTracking(round+1);
			lose[t1Index]++;
			win[t2Index]++;
		}
	}
}
