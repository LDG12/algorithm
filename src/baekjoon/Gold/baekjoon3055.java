package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon3055 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> q;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Point{
        int x,y, time, flag;
        Point(int x, int y, int time, int flag){
            this.x = x;
            this.y = y;
            this.time = time;
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static List<Point> water;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        q = new ArrayDeque<>();
        visited = new boolean[n][m];
        int startX = 0;
        int startY = 0;
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
                if(map[i][j] == '*'){
                    q.offer(new Point(i,j,0,1));
                }
            }
        }
        visited[startX][startY] = true;
        q.offer(new Point(startX, startY, 0, 0));
        bfs();
    }
    static void bfs(){
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.flag == 1){
                for(int i=0; i<4; i++){
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];
                    if(rangeCheck(nextX,nextY) && map[nextX][nextY] != 'D' && map[nextX][nextY] != 'X' && map[nextX][nextY]!='*'){
                        map[nextX][nextY] = '*';
                        q.offer(new Point(nextX,nextY,0,1));
                    }
                }
            }
            else{
                for(int i=0; i<4; i++){
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];
                    if(rangeCheck(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] !='*' && map[nextX][nextY] !='X'){
                        if(map[nextX][nextY] == 'D'){
                            System.out.println(now.time+1);
                            System.exit(0);
                        }
                        visited[nextX][nextY] = true;
                        q.offer(new Point(nextX, nextY, now.time+1, 0));
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
    static boolean rangeCheck(int x, int y){
        if(x>=0 && y>=0 && x<n && y<m){
            return true;
        }
        return false;
    }
}
