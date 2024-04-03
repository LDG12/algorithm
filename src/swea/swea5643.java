package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea5643 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static boolean[][] visited;
    static int big, small;
    static int[][] arr;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            arr = new int[n+1][n+1];
            visited = new boolean[n+1][n+1];
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[from][to] = 1;
            }
            int result = 0;
            for(int i=1; i<=n; i++){
                big = 0;
                small = 0;
                boolean[] bigs = new boolean[n+1];
                boolean[] smalls = new boolean[n+1];
                bigDfs(bigs, i);
                smallDfs(smalls, i);
                if(big+small == n-1)result++;

            }
            sb.append("#"+(tc+1)+" "+result+"\n");
        }
        System.out.print(sb.toString());
    }
    static void bigDfs(boolean[] visited, int start){
        visited[start] = true;
        for(int i=1; i<=n; i++){
            if(!visited[i] && arr[start][i] == 1){
                bigDfs(visited, i);
                big++;
            }
        }
    }
    static void smallDfs(boolean[] visited, int start){
        visited[start] = true;
        for(int i=1; i<=n; i++){
            if(!visited[i] && arr[i][start] == 1){
                smallDfs(visited, i);
                small++;
            }
        }
    }
}
