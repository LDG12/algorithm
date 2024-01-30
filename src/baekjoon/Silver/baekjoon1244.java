package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1244 {
	/**
	 * @author 임동길
	 * @date 2024-01-30
	 * @link https://www.acmicpc.net/problem/1244
	 * @keyword_solution  
	 * @input 
	 * @output   
	 * @time_complex  
	 * @perf 
	 */
	static int[] dx= {1,0,0};
	static int[] dy= {0,1,-1};
	static int[] arr;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=n; i++) {
			arr[i]= Integer.parseInt(st.nextToken()); 
		}
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1) {
				int plusNum=b;
				while(b<=n) {
					arr[b] = arr[b]==0?1:0;
					b += plusNum;
				}
			}else {
				arr[b] = arr[b]==0?1:0;
				for(int j=1; j<=(n/2); j++) {
					if(b-j<1 || b+j>n)break;
					if(arr[b-j]== arr[b+j]) {
						arr[b-j] = arr[b-j]==0?1:0;
						arr[b+j] = arr[b+j]==0?1:0;
					}
					else {
						break;
					}
				}
			}
		}
		for(int i=1; i<=n; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
		}
	}
}
