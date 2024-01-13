package inflearn._3_twopointer;
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
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max=0;
		int cnt=0;
		int start=0;
		for(int i=0; i<n; i++) {
			if(arr[i]==0)cnt++;
			if(cnt>m) {
				while(arr[start]!=0) {
					start++;
				}
				start++;
				cnt--;
			}
			max = Math.max(max, i-start+1);
		}
		System.out.println(max);
		br.close();
		bw.close();
	}
}
