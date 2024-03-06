package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon14502 {
    static int n, m, k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max;
    static StringBuilder sb;
    static Point[] walls;
    static ArrayList<Point> safe;
    static ArrayList<Point>virus;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        safe = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0)safe.add(new Point(i,j));
                if(arr[i][j] == 2)virus.add(new Point(i,j));
            }
        }
        walls = new Point[3];
        max = 0;
        dfs(0,0,new int[3]);
        System.out.println(max);
    }
    static void dfs(int depth, int start, int[]save){
        if(depth>=3){
            int[][] copyMap = new int[n][m];
            for(int i=0; i<n; i++){
                copyMap[i] = arr[i].clone();
            }
            for(int i=0; i<3; i++){
                Point now = safe.get(save[i]);
                copyMap[now.x][now.y] = 1;
            }
            bfs(copyMap);
            return;
        }
        for(int i=start; i<safe.size(); i++){
            save[depth] = i;
            dfs(depth+1, i+1, save);
        }
    }
    static void bfs(int[][] newMap){
        Queue<Point> q = new LinkedList<>(virus);
        boolean[][] visited = new boolean[n][m];
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i=0; i<4; i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(rangeCheck(nextX,nextY) && !visited[nextX][nextY] && newMap[nextX][nextY] == 0){
                    q.offer(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                    newMap[nextX][nextY] = 2;
                }
            }
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(newMap[i][j] == 0)cnt++;
            }
        }
        max = Math.max(max,cnt);
    }

    static boolean rangeCheck(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m && arr[x][y]==0) return true;
        return false;
    }
}	
