import java.util.*;
import java.util.stream.Stream;
import java.io.*;

class Solution{
	static int n,m,k;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] arr;
	static ArrayList<Integer> list;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		st =new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] cashe = new int[n];
		for(int i=0; i<m; i++) {
			int now = arr[i];
			boolean check = false;
			for(int j=0; j<n; j++) {
				if(cashe[j]==0) {
					cashe[j] = now;
					check = true;
				}
				  
			}
			if(!check) {
				for(int j=n-1; j>0; j--) {
					cashe[j] = cashe[j-1];
				}
				cashe[0]=now;
			}
		}
		sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(cashe[i]+" ");
		}
		System.out.println(sb.toString());
		br.close();
		bw.close();
	}
}
