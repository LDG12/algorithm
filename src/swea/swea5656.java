package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class swea5656 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k, min;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] numbers;
    static class Point{
        int x, y, range;
        Point(int x,int y,int range){
            this.x=x;
            this.y=y;
            this.range=range;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", range=" + range +
                    '}';
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<m; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            numbers = new int[k];
            min = n*m;
            perm(0);
            sb.append("#"+(tc+1)+" "+min+"\n");
        }
        System.out.print(sb.toString());
    }
    static void perm(int depth){
        if(depth==k){
            int[][] map = copyArray(arr);
            int result = breaBricks(map);
            if(min >result){
                min = result;
            }
            return;
        }

        for(int i=0; i<m; i++){
            numbers[depth] = i;
            perm(depth+1);
        }
    }
    static int[][] copyArray(int[][] origin){
        int[][] copy = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }
    static int breaBricks(int[][] map){
        int cnt = n*m;
        for(int i=0; i<k; i++){
            int nowY = numbers[i];
            int nowX = 0;
            boolean rangeOver = false;
            for(int j=0; j<n; j++){
                if(map[j][nowY] != 0){
                    nowX = j;
                    rangeOver = true;
                    break;
                }
            }
            if(rangeOver){
                Point now = new Point(nowX, nowY, map[nowX][nowY]);
                Queue<Point> q = new ArrayDeque<>();
                q.offer(now);
                map[nowX][nowY] = 0;
                breakBrick(map,q);
                int result = sortMap(map);
                cnt = Math.min(cnt, result);
            }
        }
        return cnt;
    }
    static void breakBrick(int[][] map, Queue<Point> q){
        while(!q.isEmpty()){
            Point now = q.poll();
            int range = now.range;
            if(range == 1)continue;
            for(int i=0; i<4; i++){
                int cnt = 0;
                int nextX = now.x;
                int nextY = now.y;
                while(cnt<range-1){
                    cnt++;
                    nextX += dx[i];
                    nextY += dy[i];
                    if(!rangeCheck(nextX,nextY))break;
                    if(map[nextX][nextY] > 0){
                        q.offer(new Point(nextX,nextY, map[nextX][nextY]));
                        map[nextX][nextY] = 0;
                    }
                }
            }
        }
    }
    static int sortMap(int[][] map){
        int cnt = 0;
        for(int i=0; i<m; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=n-1; j>=0; j--){ // i 는 width
                if(map[j][i] > 0){ // j = height
                    list.add(map[j][i]);
                    map[j][i] = 0;
                }
            }
            cnt+=list.size();
            int depth = n-1;
            for(int j=0; j<list.size(); j++){
                map[depth][i] = list.get(j);
                depth--;
            }
        }
        return cnt;
    }
    static boolean rangeCheck(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
}
