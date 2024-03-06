package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1600 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, k;
    static int[][] arr;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx2 = {1,0,-1,0};
    static int[] dy2 = {0,1,0,-1};
    static boolean[][][] visited;
    static int result;

    // 0 : 우하 (오른)
    // 1 : 우하 (아래)
    // 2 : 우상 (위)
    // 3 : 우상 (오른)
    // 4 : 좌상 (왼)
    // 5 : 좌상 (위)
    // 6 : 좌하 (좌)
    // 7 : 좌하 (아래)
    static class Point {
        int x, y, chance, pathPoint;

        public Point(int x, int y, int chance, int pathPoint) {
            this.x = x;
            this.y = y;
            this.chance = chance;
            this.pathPoint = pathPoint;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[k+1][n][m];
        result = -1;
        bfs();
    }
    static void bfs(){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0,0,0,0));
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == n-1 && now.y== m-1){
                result = now.pathPoint;
                break;
            }
            for(int i=0; i<4; i++){
                int nextX = now.x+dx2[i];
                int nextY = now.y+dy2[i];
                if(rangeCheck(nextX,nextY) && !visited[now.chance][nextX][nextY] && arr[nextX][nextY]==0){
                    q.offer(new Point(nextX, nextY, now.chance, now.pathPoint+1));
                    visited[now.chance][nextX][nextY] = true;
                }
            }
            if(now.chance<k){
                for(int i=0; i<8; i++){
                    int nextX = now.x+dx[i];
                    int nextY = now.y+dy[i];
                    if(rangeCheck(nextX,nextY) && !visited[now.chance+1][nextX][nextY] && arr[nextX][nextY]==0){
                        visited[now.chance+1][nextX][nextY] = true;
                        q.offer(new Point(nextX,nextY,now.chance+1, now.pathPoint+1));
                    }
                }
            }

        }
        System.out.println(result);
    }
    static boolean rangeCheck(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m) {
            return true;
        }
        return false;
    }
}
