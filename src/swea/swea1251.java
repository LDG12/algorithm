package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.*;

public class swea1251 {
    static class Node implements Comparable<Node> {
        int x, y, index;
        double cost;

        public Node(int x, int y, double cost, int index) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.index = index;
        }

        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }
    static class Edge implements Comparable<Edge>{
        int from, to;
        double cost;
        public Edge(int from, int to, double cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o){
            if(o == null)return 0;
            return Double.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }
    static int n, m, k, d;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min;
    static boolean[] visited;
    static StringBuilder sb;
    static int[][] inning;
    static int[] dist;
    static ArrayList<Node>[] list;
    static Node[] nodes;
    static double e;
    static ArrayList<Edge> edges;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }
            int[][] arr = new int[2][n];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            e = Double.parseDouble(br.readLine());
            nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                int x = arr[0][i];
                int y = arr[1][i];
                nodes[i] = new Node(x, y, 0, i);
            }
            edges = new ArrayList<>();
            int cnt=0;
            for(int i=0; i<n; i++){
                Node node = nodes[i];
                for(int j=i+1; j<n; j++){
                    Node next = nodes[j];
                    int distanceX = Math.abs(node.x - next.x);
                    int distanceY = Math.abs(node.y - next.y);
                    double cost = (e*Math.pow(distanceY,2))+(e*(Math.pow(distanceX,2)));
                    Edge atob = new Edge(node.index, next.index, cost);
                    edges.add(atob);
                }
            }
            Collections.sort(edges);
            parent = new int[n];
            Arrays.fill(parent, -1);
            int edgeCnt=0;
            double result = 0;
            boolean[] visited = new boolean[n];
            for(int i=0; i<edges.size(); i++){
                if(edges.get(i) == null)continue;
                Edge now = edges.get(i);
                if(union(now.from, now.to)){
                    result+=now.cost;
                    cnt++;
                }
                if(cnt==n-1)break;
            }
            long answer = Math.round(result);
            sb.append("#"+(tc+1)+" "+answer+"\n");
        }
        System.out.print(sb.toString());
        br.close();
        bw.close();
    }
    static int find(int x){
        if(parent[x] < 0){
            return x;
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }
    static boolean union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y)return false;
        else{
            if(x>y){
                parent[y] += parent[x];
                parent[x] = y;
            }
            else{
                parent[x] +=parent[y];
                parent[y] = x;
            }
            return true;
        }
    }
}
