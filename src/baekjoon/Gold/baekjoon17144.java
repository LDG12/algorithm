package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon17144 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] up = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] down = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] arr;
    static class Point{
        int x, y, value;
        Point(int x,int y, int value){
            this.x = x;
            this.y= y;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    "}\n";
        }
    }
    static Queue<Point> q;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 시간초가 지난 이후 결과 확인

        arr = new int[n][m];

        int upStartX = 0;
        int upStartY = 0;
        int downStartX = 0;
        int downStartY = 0;
        boolean flag = false;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==-1 && !flag){
                    upStartX = i;
                    upStartY = j;
                    flag = true;
                }
                else if(arr[i][j] == -1 && flag){
                    downStartX = i;
                    downStartY = j;
                }
            }
        }
        int result = 0;
        for(int i=0; i<k; i++){
            diffusion();
            moveDust(upStartX, upStartY, downStartX, downStartY);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]>0)result+=arr[i][j];
            }
        }
        System.out.println(result);
    }
    static void moveDust(int upStartX, int upStartY, int downStartX, int downStartY){
        int startX = downStartX;
        int startY = downStartY;
        int direction = 0;
        while(direction < 4){
            int nextX = startX + down[direction][0];
            int nextY = startY + down[direction][1];
            if(!rangeCheck(nextX,nextY) || nextX < downStartX){
                direction++;
                continue;
            }
            if(arr[nextX][nextY] == -1)break;
            if(arr[startX][startY] == -1)arr[nextX][nextY] = 0;
            else {
                arr[startX][startY] = arr[nextX][nextY];
                arr[nextX][nextY] = 0;
            }
            startX+=down[direction][0];
            startY+=down[direction][1];
        }
        startX = upStartX;
        startY = upStartY;
        direction = 0;
        while(direction < 4){
            int nextX = startX + up[direction][0];
            int nextY = startY + up[direction][1];
            if(!rangeCheck(nextX,nextY) || nextX > upStartX){
                direction++;
                continue;
            }
            if(arr[nextX][nextY] == -1)break;
            if(arr[startX][startY] == -1)arr[nextX][nextY] = 0;
            else {
                arr[startX][startY] = arr[nextX][nextY];
                arr[nextX][nextY] = 0;
            }
            startX+=up[direction][0];
            startY+=up[direction][1];
        }
    }
    static void diffusion(){
        q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]>0)q.offer(new Point(i,j,arr[i][j]));
            }
        }
        Queue<Point> nextQ = new ArrayDeque<>(); // arr에 값을 추가해줄 point들.
        int size = q.size();
        for(int i=0; i<size; i++){
            Point now = q.poll();
            int nextValue = now.value/5;
            int cnt = 0;
            for(int j=0; j<4; j++){
                int nextX = now.x+dx[j];
                int nextY = now.y+dy[j];
                if(rangeCheck(nextX,nextY) && arr[nextX][nextY]!=-1){
                    if(nextValue>0){
                        nextQ.offer(new Point(nextX, nextY, nextValue));
                    }
                    cnt++;
                }
            }
            if(cnt>0){
                arr[now.x][now.y] -= (cnt) * (nextValue);
                if(arr[now.x][now.y]<0)arr[now.x][now.y] = 0;
            }
        }
        size = nextQ.size();
        for(int i=0; i<size; i++){
            Point now = nextQ.poll();
            arr[now.x][now.y] += now.value;
        }
    }
    static boolean rangeCheck(int x, int y){
        if(x>=0 && y>=0 && x<n && y<m)return true;
        return false;
    }
}
