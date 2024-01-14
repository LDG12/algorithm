package inflearn._6_sorting_searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class inflearn6_7 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	arr[i][0]=x;
        	arr[i][1]=y;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
        	public int compare(int[] a1, int[] a2) {
        		if(a1[0]==a2[0]) {
        			return a1[1]-a2[1];
        		}
        		return a1[0]-a2[0];
        	}
        });
        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	sb.append(arr[i][0]+" "+arr[i][1]+"\n");
        }
        System.out.print(sb.toString());
        br.close();
        bw.close();
    }
}
