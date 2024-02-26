package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon14284 {
    static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int compareTo(Node o) {
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
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        dijkstra(start, end);
        System.out.println(dist[end]);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        boolean[] visited = new boolean[n + 1];
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.index == end) break;
            if (visited[now.index]) continue;
            visited[now.index] = true;
            for (Node next : list[now.index]) {
                int nextCost = now.cost + next.cost;
                if (dist[next.index] > nextCost) {
                    dist[next.index] = nextCost;
                    pq.offer(new Node(next.index, nextCost));
                }
            }
        }
    }
}
