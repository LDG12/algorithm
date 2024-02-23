package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1719 {
    static class Node implements Comparable<Node>{
        int index;
        int cost;
        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int n, m, k, d;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min;
    static int[] parent;
    static int[] dist;
    static int[] path;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,cost));
            list[to].add(new Node(from, cost));
        }
        sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            dist = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dijkstra(i);
        }
        System.out.print(sb.toString());

        br.close();
        bw.close();
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0;
        path = new int[n+1];
        Arrays.fill(path, -1);
        boolean[] visited = new boolean[n+1];
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.index])continue;
            visited[now.index] = true;
            for(Node next : list[now.index]){
                int nextCost = now.cost + next.cost;
                if(dist[next.index] > nextCost){
                    dist[next.index] = nextCost;
                    path[next.index] = now.index;
                    pq.offer(new Node(next.index, nextCost));
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(i==start)sb.append("-"+" ");
            else{
                sb.append(find(i,start)+" ");
            }
        }
        sb.append("\n");
    }
    static int find(int x, int start){
        if(path[x] == start){
            return x;
        }
        else{
            return find(path[x], start);
        }
    }
}
