package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class swea2383 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] arr;
    static int n, m, k;
    static int[] save;
    static ArrayList<Point> person;
    static ArrayList<Point> stair;
    static boolean[] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min;

    static class Point {
        int x, y, cost, index, targetIndex;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int targetIndex) {
            this.x = x;
            this.y = y;
            this.targetIndex = targetIndex;
        }

        public Point(int x, int y, int index, int cost, int targetIndex) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.cost = cost;
            this.targetIndex = targetIndex;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            int personCnt = 0;
            int staitCnt = 0;
            person = new ArrayList<>();
            stair = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) person.add(new Point(i, j, personCnt++, 0, 0));
                    if (arr[i][j] > 1) stair.add(new Point(i, j, staitCnt++, arr[i][j], 0));
                    }
                }
                save = new int[stair.size()];
                visited = new boolean[person.size()];
            min = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append("#" + (tc + 1) + " " + min + "\n");
            System.out.println("#"+(tc+1)+" "+min);
        }
    }

    static void dfs(int depth, int cnt) {
        if (depth >= person.size()) {

            return;
        }

        visited[depth] = true;
        dfs(depth + 1, cnt + 1);
        visited[depth] = false;
        dfs(depth + 1, cnt);
    }

    static void please(){

    }

}
