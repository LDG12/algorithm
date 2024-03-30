package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon17472 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x =x;
            this.y=y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    "}\n";
        }
    }
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] parent;
    static boolean[][] isIsland;
    static ArrayList<Edge> edges;
    public static void main(String[] args)throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isIsland = new boolean[n][m];
        edges = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]>0 && !isIsland[i][j]){
                    islandDivide(new Point(i,j), cnt++);
                }
            }
        }
        islandConnect();
        parent = new int[cnt];
        Arrays.fill(parent, -1);
        Collections.sort(edges);
        int result = 0;
        int resultCnt = 0;
        for(int i=0; i<edges.size(); i++){
            Edge now = edges.get(i);
            if(union(now.from, now.to)){
                resultCnt++;
                result+=now.cost;
            }
        }
        if(result == 0 || resultCnt != cnt-2){
            System.out.println("-1");
        }
        else{
            System.out.println(result);
        }
    }
    static void islandConnect(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] > 0){
                    for(int k=0; k<4; k++){
                        int nextX = i+dx[k];
                        int nextY = j+dy[k];
                        int distance = 0;
                        if(!rangeCheck(nextX,nextY))continue;
                        boolean rangeOver = false;
                        while(map[nextX][nextY] == 0){
                            nextX+=dx[k];
                            nextY+=dy[k];
                            distance++;
                            if(!rangeCheck(nextX,nextY)){
                                rangeOver = true;
                                break;
                            }
                        }
                        if(!rangeOver && distance>1 && map[i][j] != map[nextX][nextY]){
                            edges.add(new Edge(map[i][j], map[nextX][nextY], distance));
                        }
                    }
                }
            }
        }
    }
    static void islandDivide(Point start, int cnt){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(start);
        map[start.x][start.y] = cnt;
        isIsland[start.x][start.y] = true;
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i=0; i<4; i++){
                int nextX= now.x+dx[i];
                int nextY= now.y+dy[i];
                if(rangeCheck(nextX,nextY) &&!isIsland[nextX][nextY] && map[nextX][nextY]==1){
                    map[nextX][nextY] = cnt;
                    isIsland[nextX][nextY] = true;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }
    }
    static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y){
            return false;
        }
        else{
            if(x<y){
                parent[x] += parent[y];
                parent[y] = x;
            }
            else{
                parent[y] +=parent[x];
                parent[x] = y;
            }
            return true;
        }
    }
    static int find(int x){
        if(parent[x] < 0){
            return x;
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }
    static boolean rangeCheck(int x, int y){
        if(x>=0 && y>=0 && x<n && y<m)return true;
        return false;
    }
}
