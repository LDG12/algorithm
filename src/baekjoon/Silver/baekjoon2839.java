package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2839 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	static int max;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		int cnt=0;
		while(n!=0) {
			if(n<5 && n%3!=0) {
				break;
			}
			if(n%5==0) {
				cnt+=n/5;
				n = n%5;
				break;
			}
			n-=3;
			cnt++;
		}
		if(n==0) {
			sb.append(cnt);
		}else {
			sb.append(-1);
		}
		System.out.println(sb.toString());
	}
}
