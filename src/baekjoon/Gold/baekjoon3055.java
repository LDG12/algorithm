package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon3055 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static char[][] map;
    static boolean[][]waterVisited;
    static boolean[][] visited;
    static Queue<Point> q;
    static Queue<Point> waterQ;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Point{
        int x,y, time;
        Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
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
        waterQ = new ArrayDeque<>();
        waterVisited = new boolean[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'S'){
                    q.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                }
                if(map[i][j] == '*'){
                    waterVisited[i][j] = true;
                    waterQ.offer(new Point(i,j, 0));
                }
            }
        }
        bfs();
    }
    static void bfs(){
        while(!q.isEmpty()){
            int waterSize = waterQ.size();
            for(int i=0; i<waterSize; i++){
                Point water = waterQ.poll();
                for(int j=0; j<4; j++){
                    int nextX = water.x + dx[j];
                    int nextY = water.y + dy[j];

                    if(rangeCheck(nextX,nextY) && !waterVisited[nextX][nextY] && map[nextX][nextY]!='D' && map[nextX][nextY]!='X'){
                        map[nextX][nextY] = '*';
                        waterVisited[nextX][nextY] = true;
                        waterQ.offer(new Point(nextX, nextY, 0));
                    }
                }
            }
            int size = q.size();
            for(int i=0; i<size; i++){
                Point now = q.poll();
                for(int j=0; j<4; j++){
                    int nextX = now.x + dx[j];
                    int nextY = now.y + dy[j];
                    if(rangeCheck(nextX,nextY)&&!visited[nextX][nextY]&& map[nextX][nextY]!='X' && map[nextX][nextY]!='*'){
                        if(map[nextX][nextY] == 'D'){
                            System.out.println(now.time+1);
                            System.exit(0);
                        }
                        else{
                            visited[nextX][nextY] = true;
                            q.offer(new Point(nextX,nextY,now.time+1));
                            map[nextX][nextY] = 'S';
                        }
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
