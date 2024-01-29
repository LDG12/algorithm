package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2615 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[][] arr;
	static int direction;
	static int deltas[][] = {
            {0, 1}, // 우
            {1, 1}, // 우하
            {1, 0}, // 하
            {1, -1}, // 좌하
            {0, -1}, // 좌
            {-1, -1}, // 좌상
            {-1, 0}, // 상
            {-1, 1} // 우상
    };
	static StringTokenizer st; 	 
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[19][19];
		// 검은 알은 1.
		// 흰 알은 2.
		// 놓이지 않은 자리는 0
		result = new int[5][2];
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int j=0; j<19; j++) {
			for(int i=0; i<19; i++) {
				if(arr[i][j]!=0) {
					for(int k=0; k<4; k++) {
						boolean check = bingo(i, j, arr[i][j], k);
						if(check) {
							System.out.println(arr[i][j]);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
					}
				}
			}
		}
		System.out.println("0");
	}
	static boolean bingo(int x, int y, int num, int direction) {
		boolean check = false;
		int nextX = x + deltas[direction][0];
		int nextY = y + deltas[direction][1];
		int prevX = x + deltas[direction+4][0];
		int prevY = y + deltas[direction+4][1];
		int prevCnt=0;
		int cnt=1;
		while(check(prevX, prevY) && arr[prevX][prevY]==num) {
			prevCnt++;
			prevX+=deltas[direction+4][0];
			prevY+=deltas[direction+4][1];
		}
		while(check(nextX,nextY)&& arr[nextX][nextY]==num ) {
			cnt++;
			nextX+=deltas[direction][0];
			nextY+=deltas[direction][1];
		}
		cnt+=prevCnt;
		if(cnt==5)return true;
		return false;
	}
	static boolean check(int x, int y) {
		if(x>=0 && y>= 0 && x<19 && y<19) {
			return true;
		}
		return false;
	}
}
