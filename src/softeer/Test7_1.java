package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test7_1 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k, cnt;
    static int[][] arr;
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x =x;
            this.y = y;
        }

    }
    static Point[] points;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        points = new Point[m];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            points[i] = new Point(x,y);
        }
        visited = new boolean[n][n];
        visited[points[0].x][points[0].y] = true;
        int startX = points[0].x;
        int startY = points[0].y;
        dfs(startX, startY, 1);
        System.out.println(cnt);
    }
    static void dfs(int x, int y, int depth){
        if(x == points[depth].x && y == points[depth].y){
            if(depth == m-1){
                cnt++;
                return;
            }
            depth++;
        }
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(rangeCheck(nextX,nextY) && !visited[nextX][nextY]){
                visited[nextX][nextY] = true;
                dfs(nextX,nextY,depth);
                visited[nextX][nextY] = false;
            }
        }
    }
    static boolean rangeCheck(int x, int y){
        if(x>=0 && y>=0 && x<n && y<n && arr[x][y] == 0)return true;
        return false;
    }
}
