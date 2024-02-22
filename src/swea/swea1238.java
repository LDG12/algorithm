package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class swea1238 {
    static class Node {
        int index;
        int cnt;

        public Node(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", cnt=" + cnt +
                    '}';
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

    public static void main(String[] args) throws Exception {
        //여기에 코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for (int tc = 0; tc < 10; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new ArrayList[101];
            for(int i=1; i<=100; i++){
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
            }
            boolean[] visited = new boolean[101];
            int[] depth = new int[101];
            Queue<Integer>q = new ArrayDeque<>();
            q.offer(m);
            visited[m] = true;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    int now = q.poll();
                    for(int next : list[now]){
                        if(!visited[next]){
                            visited[next] = true;
                            depth[next] = depth[now]+1;
                            q.offer(next);
                        }
                    }
                }
            }
            int maxValue=0;
            int maxDepth=0;
            for(int i=0; i<=100; i++){
                if(depth[i] >= maxDepth){
                    if(i>maxValue){
                        maxDepth = depth[i];
                        maxValue = i;
                    }
                }
            }
            sb.append("#"+(tc+1)+" "+maxValue+"\n");
        }
        System.out.print(sb.toString());
    }
}
