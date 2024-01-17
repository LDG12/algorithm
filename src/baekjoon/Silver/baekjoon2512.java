package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class baekjoon2512 {
	static int[] dx = {1,0,-1,0,-1,1,-1,1};
	static int[] dy = {0,1,0,-1,-1,1,1,-1};
	static char[][] arr;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[n];
		int max = 0;
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken()); 
			max = Math.max(max, arr[i]);
		}
		int m = Integer.parseInt(br.readLine());
		int lt =0;
		int rt = max;
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			long sum =0;
			for(int i=0; i<n; i++) {
				if(arr[i]<=mid) {
					sum+=arr[i];
				}
				else {
					sum+=mid;
				}
			}
			if(sum<=m) {
				lt = mid+1;
			}
			else {
				rt = mid-1;
			}
		}
		System.out.println(rt);
	}
}
