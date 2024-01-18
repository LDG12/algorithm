package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon9251 {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        String compareWord = br.readLine();
        int[][] dp = new int[word.length()+1][compareWord.length()+1];
        for(int i=1; i<word.length()+1;i++) {
        	for(int j=1; j<compareWord.length()+1; j++) {
        		if(word.charAt(i-1)== compareWord.charAt(j-1)) {
        			dp[i][j] =dp[i-1][j-1]+1;
        			continue;
        		}
        		dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        	}
        }
        System.out.println(dp[word.length()][compareWord.length()]);
        br.close();
        bw.close();
    }
}
