package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon17471 {


    static int n, m, k, d;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min;
    static int[] parent;
    static int[] parentValue;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int ssum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        parent = new int[n + 1];
        parentValue = new int[n + 1];
        ssum=0;
        for (int i = 1; i <= n; i++) {
            parentValue[i] = Integer.parseInt(st.nextToken());
            ssum+=parentValue[i];
        }
        Arrays.fill(parent, -1);
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int adjCnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < adjCnt; j++) {
                int now = Integer.parseInt(st.nextToken());
                list[i].add(now);
                list[now].add(i);
            }
        }
        min = Integer.MAX_VALUE;
        subset(1,0);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }
        br.close();
        bw.close();
    }
    static boolean[] copyArray(){

        boolean[] copy = new boolean[n+1];
        for(int i=1; i<=n; i++){
            copy[i] = visited[i];
        }
        return copy;
    }
    static boolean bfs(boolean[] innerVisited){
        int start=1;
        for(int i=1; i<=n; i++){
            if(innerVisited[i])start=i;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] outerVisited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!innerVisited[i])outerVisited[i] = true;
        }
        boolean[] bfsVisited = new boolean[n+1];
        bfsVisited[start] = true;
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list[now]){
                if(!bfsVisited[next] && !outerVisited[next]){
                    bfsVisited[next] = true;
                    q.offer(next);
                }
            }
        }
        if(Arrays.equals(innerVisited,bfsVisited)){
            return true;
        }
        return false;
    }

    static void subset(int depth, int sum) {
        if (depth == n + 1) {
            boolean[] innerVisited = copyArray();
            boolean first = bfs(innerVisited);
            boolean[] outerVisited = new boolean[n+1];
            for(int i=1; i<=n; i++){
                if(!innerVisited[i])outerVisited[i] = true;
            }
            boolean second = bfs(outerVisited);
            if(first && second){
                int result = Math.abs(ssum-sum);
                int realResult = Math.abs(result-sum);
                min = Math.min(min,realResult);
            }
            return;
        }

        visited[depth] = true;
        subset(depth + 1, sum+parentValue[depth]);
        visited[depth] = false;
        subset(depth + 1, sum);
    }
}
