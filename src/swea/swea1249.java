package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea1249 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k,arr[][];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] dist;
    static class Node implements Comparable<Node>{
        int x,y, cost;
        public Node(int x, int y,int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb  = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            dist = new int[n][n];
            for(int i=0;i<n;i++){
                String tmp = br.readLine();
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                for(int j=0;j<n;j++){
                    arr[i][j] = tmp.charAt(j)-'0';
                }
            }
            dijkstra(tc);
        }
        System.out.print(sb.toString());
    }
    static void dijkstra(int tc){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        boolean[][] visited = new boolean[n][n];
        pq.offer(new Node(0,0,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.x][now.y])continue;
            visited[now.x][now.y] = true;
            for(int i=0; i<4; i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(rangeCheck(nextX,nextY) && dist[nextX][nextY] > arr[nextX][nextY]+now.cost){
                    int nextValue = arr[nextX][nextY] + now.cost;
                    dist[nextX][nextY] = nextValue;
                    if(nextX == n-1 && nextY == n-1){
                        sb.append("#"+(tc+1)+" "+dist[nextX][nextY]+"\n");
                        return;
                    }
                    pq.offer(new Node(nextX,nextY, nextValue));
                }
            }
        }
    }
    static boolean rangeCheck(int x,int y){
        if(x>=0 && y>=0 && x<n && y<n)return true;
        return false;
    }
}
