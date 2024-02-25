package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1922 {
    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
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
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static Edge[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        m = Integer.parseInt(br.readLine());
        Arrays.fill(parent, -1);
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, cost);
        }
        int cnt = 0;
        int result = 0;
        Arrays.sort(edges);
        for (int i = 0; i < m; i++) {
            Edge now = edges[i];
            if (union(now.from, now.to)) {
                cnt++;
                result += now.cost;
            }
            if (cnt == n - 1) {
                break;
            }
        }
        System.out.println(result);
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
            if (x > y) {
                parent[y] += parent[x];
                parent[x] = y;
            } else {
                parent[x] += parent[y];
                parent[y] = x;
            }
            return true;
        }
    }
}
