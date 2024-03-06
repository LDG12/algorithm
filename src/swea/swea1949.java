package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1949 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, k, peakmax;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Point> peak;

    static class Point {
        int x, y, cost, max;

        public Point(int x, int y, int cost, int max) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            peak = new ArrayList<>();
            arr = new int[n][n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] > max) max = arr[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == max) peak.add(new Point(i, j, arr[i][j], 1));
                }
            }
            peakmax = 0;
            for (int i = 0; i < peak.size(); i++) {
                Point now = peak.get(i);
                boolean[][] visited = new boolean[n][n];
                visited[now.x][now.y] = true;
                dfs(now.x, now.y, k, arr[now.x][now.y], 1, visited, now);
            }
            sb.append("#"+(tc+1)+" "+peakmax+"\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int x, int y, int chance, int nowPeak, int max, boolean[][] visited, Point from) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (rangeCheck(nextX, nextY) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                if(chance == 0){
                    if(arr[nextX][nextY] < nowPeak){
                        dfs(nextX, nextY, chance, arr[nextX][nextY],max+1, visited, from);
                    }
                }
                else{
                    if(arr[nextX][nextY]< nowPeak){
                        dfs(nextX,nextY, chance, arr[nextX][nextY],max+1,visited,from);
                    }
                    else if(arr[nextX][nextY]-chance<nowPeak){
                        dfs(nextX,nextY,0,nowPeak-1,max+1,visited,from);
                    }
                }
                visited[nextX][nextY] = false;
            }
        }
        if (peakmax < max) {
            peakmax = max;
        }
    }

    static boolean rangeCheck(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n) return true;
        return false;
    }
}
/*
10
5 1
9 3 2 3 2
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8
 */