package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon17070 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, k;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static int[][] pipe;
    static int max;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pipe = new int[n][n];
        max = 0;
        dp = new int[n][n];
        dfs(0,1,0);
        System.out.println(max);
        // 현재 상태가 0이면 가로, 1이면 세로, 2면 대각선

    }

    static void dfs(int x, int y, int state) {
        if(x == n-1 && y== n-1){
            max++;
            return;
        }
        int nextX;
        int nextY;
        if(state == 0){
            nextX = x+dx[0];
            nextY = y+dy[0];
            if(rangeCheck(nextX,nextY)){
                if(pipeCheck(nextX,nextY)){
                    pipe[nextX][nextY] = 1;
                    dfs(nextX,nextY,0);
                    pipe[nextX][nextY] = 0;
                }
            }
            nextX = x+dx[2];
            nextY = y+dy[2];
            if(rangeCheck(nextX,nextY)){
                if(pipeCheck(nextX,nextY) && pipeCheck(nextX-1, nextY) && pipeCheck(nextX,nextY-1)){
                    pipe[nextX][nextY] = 1;
                    pipe[nextX-1][nextY] = 1;
                    pipe[nextX][nextY-1] = 1;
                    dfs(nextX,nextY,2);
                    pipe[nextX][nextY] = 0;
                    pipe[nextX-1][nextY] = 0;
                    pipe[nextX][nextY-1] = 0;
                }
            }
        }
        else if(state==1){
            nextX = x+dx[1];
            nextY = y+dy[1];
            if(rangeCheck(nextX,nextY)){
                if(pipeCheck(nextX,nextY)){
                    pipe[nextX][nextY] = 1;
                    dfs(nextX,nextY,1);
                    pipe[nextX][nextY] = 0;
                }
            }
            nextX = x+dx[2];
            nextY = y+dy[2];
            if(rangeCheck(nextX,nextY)){
                if(pipeCheck(nextX,nextY) && pipeCheck(nextX-1, nextY) && pipeCheck(nextX,nextY-1)){
                    pipe[nextX][nextY] = 1;
                    pipe[nextX-1][nextY] = 1;
                    pipe[nextX][nextY-1] = 1;
                    dfs(nextX,nextY,2);
                    pipe[nextX][nextY] = 0;
                    pipe[nextX-1][nextY] = 0;
                    pipe[nextX][nextY-1] = 0;
                }
            }
        }
        else if(state==2){
            nextX = x+dx[0];
            nextY = y+dy[0];
            if(rangeCheck(nextX,nextY)){
                if(pipeCheck(nextX,nextY)){
                    pipe[nextX][nextY] = 1;
                    dfs(nextX,nextY,0);
                    pipe[nextX][nextY] = 0;
                }
            }
            nextX = x+dx[1];
            nextY = y+dy[1];
            if(rangeCheck(nextX,nextY)){
                if(pipeCheck(nextX,nextY)){
                    pipe[nextX][nextY] = 1;
                    dfs(nextX,nextY,1);
                    pipe[nextX][nextY] = 0;
                }
            }
            nextX = x+dx[2];
            nextY = y+dy[2];
            if(rangeCheck(nextX,nextY)){
                if(pipeCheck(nextX,nextY) && pipeCheck(nextX-1, nextY) && pipeCheck(nextX,nextY-1)){
                    pipe[nextX][nextY] = 1;
                    pipe[nextX-1][nextY] = 1;
                    pipe[nextX][nextY-1] = 1;
                    dfs(nextX,nextY,2);
                    pipe[nextX][nextY] = 0;
                    pipe[nextX-1][nextY] = 0;
                    pipe[nextX][nextY-1] = 0;
                }
            }
        }
    }

    static boolean rangeCheck(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) return false;
        if(arr[x][y]==1)return false;
        return true;
    }
    static boolean pipeCheck(int x,int y){
        if(pipe[x][y] == 1 || arr[x][y]==1)return false;
        return true;
    }
}
