package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1194 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k, time;
    static char[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Point{
        int x, y, key, time;
        Point(int x, int y, int key){
            this.x = x;
            this.y = y;
            this.key = key;
        }
        Point(int x, int y, int key, int time){
            this.x = x;
            this.y = y;
            this.key = key;
            this.time = time;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        int startX = 0;
        int startY = 0;
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == '0'){
                    startX = i;
                    startY = j;
                }
            }
        }
        time = -1;
        bfs(startX, startY);
        System.out.println(time);
    }
    static void bfs(int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[64][n][m];
        visited[0][x][y] =true;
        q.offer(new Point(x,y,0,0));
        while(!q.isEmpty()){
            Point now = q.poll();
            if(map[now.x][now.y] == '1'){
                time = now.time;
                break;
            }
            for(int i=0; i<4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if(!rangeCheck(nextX,nextY))continue;
                if(visited[now.key][nextX][nextY] || map[nextX][nextY]=='#')continue;
                if(map[nextX][nextY]>='a' && map[nextX][nextY] <= 'f'){
                    int key = 1 << (map[nextX][nextY]-'a');
                    int nextKey = now.key | key;
                    visited[nextKey][nextX][nextY] = true;
                    q.offer(new Point(nextX, nextY, nextKey, now.time+1));
                }
                else if(map[nextX][nextY] >= 'A' && map[nextX][nextY]<='F'){
                    int bit = 1 << (map[nextX][nextY]-'A');
                    if((now.key & bit) == bit){
                        visited[now.key][nextX][nextY] = true;
                        q.offer(new Point(nextX,nextY,now.key, now.time+1));
                    }
                }else{
                    visited[now.key][nextX][nextY] = true;
                    q.offer(new Point(nextX, nextY, now.key, now.time+1));
                }
            }
        }
    }
    static boolean rangeCheck(int x, int y){
        if(x>=0 && y>=0 && x<n && y<m)return true;
        return false;
    }
}
