package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1774 {
    static class Edge implements Comparable<Edge>{
        int from, to;
        long cost;
        public Edge(int from, int to, long cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o){
            return Long.compare(this.cost, o.cost);
        }
    }
    static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] dist;
    static Edge[] edges;
    static int[] parent;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        edges = new Edge[(n*n)-n];
        int index=0;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=n; j++){
                if(i==j){
                    int garbage = Integer.parseInt(st.nextToken());
                    continue;
                }
                long cost = Long.parseLong(st.nextToken());
                Edge now = new Edge(i,j,cost);
                edges[index++] = now;
            }
        }
        Arrays.sort(edges);
        parent = new int[n+1];
        Arrays.fill(parent, -1);
        int cnt=0;
        long result=0;
        for(int i=0; i<edges.length; i++){
            Edge now = edges[i];
            if(union(now.from, now.to)){
                cnt++;
                result+=now.cost;
            }
            if(cnt==n-1)break;
        }
        System.out.println(result);
        br.close();
        bw.close();
    }
    static int find(int x){
        if(parent[x] <0){
            return x;
        }
        else{
            return parent[x]=find(parent[x]);
        }
    }
    static boolean union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y){
            return false;
        }
        else{
            if(x>y){
                parent[y] += parent[x];
                parent[x] = y;
            }
            else{
                parent[x] += parent[y];
                parent[y] = x;
            }
            return true;
        }
    }
}
