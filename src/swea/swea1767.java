package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author 임동길
 * @date 2024-02-28
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV4suNtaXFEDFAUf&probBoxId=AY3s7Te6B9kDFAUZ&type=PROBLEM&problemBoxTitle=0226%EC%A3%BC&problemBoxCnt=1
 * @keyword_solution
 * 1. 완전탐색 + 재귀 + 구현
 * 2. 코어는 가장 "많이", 전선은 가장 "적게" 사용하는 경우의 수를 출력
 * 3. 재귀가 종료되면 map을 원형으로 복구하기.
 * @input
 * 7<=N<=12
 * 1<= 코어 <= 12
 * @output
 *
 * @time_complex
 * O(N²)
 * @perf 23,848kb, 832ms
 */
public class swea1767 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, maxCore, maxWire;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Point{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Point> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            int cnt = 0;
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if ((i == 0 || j == 0 || i == n - 1 || j == n - 1) && arr[i][j] == 1) {
                        cnt++;
                    }
                    else if((i != 0 && j != 0 && i != n - 1 && j != n - 1) && arr[i][j] == 1 ){
                        list.add(new Point(i,j));
                    }
                }
            }
            maxWire = Integer.MAX_VALUE;
            maxCore = 0;
            dfs(0,0,0);
            sb.append("#"+(tc+1)+" "+maxWire+"\n");
        }
        System.out.print(sb.toString());
    }
    static void dfs(int depth, int core, int wire){
        if(depth==list.size()){
            if(maxCore>core)return;
            if(maxCore < core) { // 최대한 많은 core에 연결
                maxCore = core;
                maxWire = wire;
            } else if(maxCore == core) { // 전선길이의 합이 최소가 되는 값
                maxWire = Math.min(maxWire, wire);
            }
            return;
        }
        Point now = list.get(depth);
        int nowX = now.x;
        int nowY = now.y;
        for(int i=0; i<4; i++){
            int nextX = now.x;
            int nextY = now.y;
            int cnt=0;
            while(true){
                nextX += dx[i];
                nextY += dy[i];
                if(!rangeCheck(nextX,nextY)){
                    break;
                }
                if(arr[nextX][nextY] == 1){
                    cnt=0;
                    break;
                }
                cnt++;
            }
            int startX = now.x;
            int startY = now.y;
            for(int j=0; j<cnt; j++){
                startX += dx[i];
                startY += dy[i];
                arr[startX][startY] = 1;
            }
            if(cnt==0){
                dfs(depth+1, core, wire);
            }
            else{
                dfs(depth+1, core+1, wire+cnt);
                startX = now.x;
                startY = now.y;
                for(int j=0; j<cnt; j++){
                    startX+=dx[i];
                    startY+=dy[i];
                    arr[startX][startY] = 0;
                }
            }
        }
    }
    static boolean rangeCheck(int x, int y){
        if(x>=0 && y>=0 && x<n && y<n)return true;
        return false;
    }
}
