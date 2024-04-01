package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2146 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k, min, num;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Bridge> bridge;
    static class Point{
        int x, y, distance;
        Point(int x, int y, int distance){
            this.x = x;
            this.y= y;
            this.distance = distance;
        }
    }
    static class Bridge{
        int x, y, num;
        Bridge(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        min = Integer.MAX_VALUE;
        bridge = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][n];
        int cnt = 1;
        num = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]!=1)continue;
                divideIslands(i,j);
            }
        }
        dist = new int[n][n];
        setBridge();
        System.out.println(min-1);
    }
    static void setBridge() {
        while (!bridge.isEmpty()) {
            Bridge brg = bridge.poll();
            int now_x = brg.x;
            int now_y = brg.y;
            int IsNum = brg.num;
            int path = dist[now_x][now_y];
            for (int k = 0; k < 4; k++) {
                int new_x = now_x + dx[k];
                int new_y = now_y + dy[k];
                if (new_x < 0 || new_x >= n || new_y < 0 || new_y >= n) continue;
                int num = arr[new_x][new_y];
                if (num == IsNum) continue;
                if (num == 0) {
                    dist[new_x][new_y] = path + 1;
                    arr[new_x][new_y] = IsNum;
                    bridge.add(new Bridge(new_x, new_y, IsNum));
                } else {
                    min = Math.min(min, path + dist[new_x][new_y]);
                }
            }
        }
    }
    static void divideIslands(int x, int y) {
        Queue<int[]> q  = new ArrayDeque<>();
        arr[x][y] = ++num;
        q.add(new int[]{x, y});
        bridge.add(new Bridge(x, y, num));
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int now_x = node[0];
            int now_y = node[1];
            for (int k = 0; k < 4; k++) {
                int new_x = now_x + dx[k];
                int new_y = now_y + dy[k];
                if (new_x < 0 || new_x >= n || new_y < 0 || new_y >= n) continue;
                if (arr[new_x][new_y] != 1) continue;
                arr[new_x][new_y] = num;
                q.add(new int[]{new_x, new_y});
                bridge.add(new Bridge(new_x, new_y, num));
            }
        }
    }
    static boolean rangeCheck(int x, int y){
        if(x>=0 && y>=0 && x<n && y<n)return true;
        return false;
    }
}
