package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon9205 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static class Point{
        int x, y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static Point[] convi;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            convi = new Point[n];
            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                convi[i] = new Point(x,y);
            }
            st = new StringTokenizer(br.readLine(), " ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            Point start = new Point(startX, startY);
            Point end = new Point(endX, endY);
            bfs(start, end);
        }
    }
    static void bfs(Point start, Point end){
        Queue<Point> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.offer(start);
        while(!q.isEmpty()){
            Point now = q.poll();
            if(Math.abs(now.x-end.x)+Math.abs(now.y-end.y)<=1000){
                System.out.println("happy");
                return;
            }
            for(int i=0; i<n; i++){
                if(visited[i]) continue;
                int distance = Math.abs(now.x - convi[i].x) + Math.abs(now.y - convi[i].y);
                if(distance <= 1000){
                    visited[i] = true;
                    q.offer(new Point(convi[i].x, convi[i].y));
                }
            }
        }
        System.out.println("sad");
    }
}
