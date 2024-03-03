package baekjoon.Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon3197 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, k;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> waterQ = new ArrayDeque<>();
        visited = new boolean[n][m];
        Node[] nodes = new Node[2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
                if (arr[i][j] != 'X') {
                    waterQ.offer(new Node(i, j));
                }
                if (arr[i][j] == 'L') {
                    nodes[index++] = new Node(i, j);
                }
            }
        }
        q.offer(nodes[0]);
        visited[nodes[0].x][nodes[0].y] = true;
        int time = 0;
        boolean meet = false;
        while(true){
            Queue<Node> nextQ = new ArrayDeque<>();
            while(!q.isEmpty()){
                Node now = q.poll();
                if(now.x == nodes[1].x && now.y == nodes[1].y){
                    meet = true;
                    break;
                }
                for(int i=0; i<4; i++){
                    int nextX = now.x+dx[i];
                    int nextY = now.y+dy[i];
                    if(nextX<0 || nextY<0|| nextX>=n || nextY>=m || visited[nextX][nextY])continue;
                    visited[nextX][nextY] = true;
                    if(arr[nextX][nextY] == 'X'){
                        nextQ.offer(new Node(nextX,nextY));
                        continue;
                    }
                    q.offer(new Node(nextX,nextY));
                }
            }
            if(meet)break;
            q = nextQ;
            int size = waterQ.size();
            for(int i=0; i<size; i++){
                Node now = waterQ.poll();
                for(int j=0; j<4; j++){
                    int nextX = now.x+dx[j];
                    int nextY = now.y+dy[j];
                    if(nextX<0 || nextY<0|| nextX>=n || nextY>=m)continue;
                    if(arr[nextX][nextY]== 'X'){
                        arr[nextX][nextY] = '.';
                        waterQ.offer(new Node(nextX,nextY));
                    }
                }
            }
            time++;
        }
        System.out.println(time);
        br.close();
    }
}
