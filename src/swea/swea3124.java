package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea3124 {
    static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
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
    static Edge[] edges;
    static StringBuilder sb;
    static ArrayList<Edge>[] list;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        //여기에 코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[from].add(new Edge(to, cost));
                list[to].add(new Edge(from, cost));
            }
            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<Edge>  pq = new PriorityQueue<>();
            long cost = 0;
            int cnt = 0;
            visited = new boolean[n+1];
            visited[1] = true;
            for(Edge now : list[1]){
                pq.offer(now);
            }
            while(!pq.isEmpty()){
                Edge now = pq.poll();
                if(visited[now.to])continue;
                visited[now.to] = true;
                cost += now.cost;
                cnt++;
                if(cnt == n-1)break;
                for(Edge next : list[now.to]){
                    if(!visited[next.to]){
                        pq.offer(next);
                    }
                }
            }
            sb.append("#"+(tc+1)+" "+cost+"\n");
        }

        System.out.print(sb.toString());
    }

    static int find(int x) {
        if (parent[x] < 0) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        } else {
            if (x < y) {
                parent[x] += parent[y];
                parent[y] = x;
            } else {
                parent[y] += parent[x];
                parent[x] = y;
            }
            return true;
        }

    }
}
