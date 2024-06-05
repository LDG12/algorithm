package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16724 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int cnt;
    static int[][] arr;
    static boolean[][] visited;
    static boolean[][] cycle;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    "}\n";
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        cycle = new boolean[n][m];
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = getDirection(tmp.charAt(j));
            }
        }
        cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        int nextX = x+dx[arr[x][y]];
        int nextY = y+dy[arr[x][y]];
        if(inRange(nextX,nextY) && !visited[nextX][nextY]){
            dfs(nextX,nextY);
        }
        else{
            if(!cycle[nextX][nextY])cnt++;
        }
        cycle[x][y] = true;
    }
    static boolean inRange(int x, int y){
        if(x>=0 && x<n && y>=0 && y<m)return true;
        return false;
    }
    static int getDirection(char dir){
        if(dir == 'D')return 0;
        else if(dir == 'R')return 1;
        else if(dir == 'U')return 2;
        else return 3;
    }
}
