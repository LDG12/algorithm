package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1263 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int[][] arr;
    static final int INF = 1000000000;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int size = st.countTokens();
            arr = new int[n+1][n+1];
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(i!=j && arr[i][j] == 0)arr[i][j] = INF;
                }
            }
            for(int k=1; k<=n; k++){
                for(int i=1; i<=n; i++){
                    for(int j=1; j<=n; j++){
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i=1; i<=n; i++){
                int sum = 0;
                for(int j=1; j<=n; j++){
                    if(i==j)continue;
                    sum += arr[i][j];
                }
                if(sum<min){
                    min = sum;
                    minIndex = i;
                }
            }
            System.out.println("#"+(tc+1)+" "+min);
        }
    }
}
