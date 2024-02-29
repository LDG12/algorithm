package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon10971 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k, min;
    static int[][] arr;
    static int[] oneWay;
    static boolean[] visited;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            visited = new boolean[n];
            visited[i] = true;
            dfs(i,i,0,0);
        }
        System.out.println(min);
    }
    private static void dfs(int start, int now, int depth, int sum) {
        if (depth == n - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                min = Math.min(min, sum);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[now][i] > 0) {
                visited[i] = true;
                dfs(start, i, depth + 1, sum + arr[now][i]);
                visited[i] = false;
            }
        }
    }
}
