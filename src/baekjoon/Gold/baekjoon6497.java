package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon6497 {
    static class Edge implements Comparable<Edge>{
        int from, to;
        long cost;
        public Edge(int from, int to, long cost){
            this.from = from;
            this.to=to;
            this.cost=cost;
        }
        public int compareTo(Edge o){
            return Long.compare(this.cost, o.cost);
        }
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};  // 0 = 남 // 1 = 동 // 2 = 북 // 3 = 서
    static int direction;
    static int n, m, k;
    static StringTokenizer st;
    static boolean[] visited;
    static int[][] result;
    static char[][] arr2;
    static int max;
    static int[] parent;
    static StringBuilder sb;
    static int[] dist;
    static ArrayList<Integer>[] list;
    static Edge[] edges;

    public static void main(String[] args) throws Exception {
        //여기에 코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m==0 && n==0)break;
            parent = new int[m];
            edges = new Edge[n];
            Arrays.fill(parent,-1);
            long result2=0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                long cost = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(from, to, cost);
                result2+=cost;
            }
            Arrays.sort(edges);
            int cnt=0;
            long result=0;
            for(int i=0; i<n; i++){
                Edge now = edges[i];
                if(union(now.from, now.to)){
                    cnt++;
                    result+=now.cost;
                }
                if(cnt==m-1)break;
            }
            System.out.println(result2-result);
        }
    }
    static int find(int x){
        if(parent[x] < 0 ){
            return x;
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }
    static boolean union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y){
            return false;
        }
        else{
            if(x<y){
                parent[x]+=parent[y];
                parent[y] = x;
            }
            else{
                parent[y]+=parent[x];
                parent[x] = y;
            }
            return true;
        }
    }
}
